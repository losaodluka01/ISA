package ftn.isamrs.tim32.controller;

import ftn.isamrs.tim32.dto.AccountDTO;
import ftn.isamrs.tim32.exception.BadRequestException;
import ftn.isamrs.tim32.exception.NotFoundException;
import ftn.isamrs.tim32.model.Account;
import ftn.isamrs.tim32.model.Friendship;
import ftn.isamrs.tim32.model.enumeration.FriendshipStatus;
import ftn.isamrs.tim32.service.AccountService;
import ftn.isamrs.tim32.service.FriendshipService;
import ftn.isamrs.tim32.util.JWTUtills;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class UserController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private FriendshipService friendshipService;

    @Autowired
    private JWTUtills jwtUtils;

    @RequestMapping(
            value = "/api/check_username",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(
            value = "Check does given username already exist.",
            notes = "You must provide valid username in the URL.",
            httpMethod = "GET",
            produces = "application/json"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully checked availability of given username"),
            @ApiResponse(code = 400, message = "Username parameter is missing")
    })
    public ResponseEntity checkUsername(
            @ApiParam(value = "User's username") @RequestParam("username") String username) {

        if (username == null || username.equals(""))
            throw new BadRequestException("Username can't be empty!");

        return new ResponseEntity(this.accountService.isUsernameTaken(username), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/send_request",
            method = RequestMethod.POST,
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(
            value = "Send a request for friendship to another user.",
            notes = "User has to exist, and not be in your friendlist.",
            httpMethod = "POST",
            consumes = "text/plain",
            produces = "application/json"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Friend request successfully sent"),
            @ApiResponse(code = 404, message = "User doesn't exist")
    })
    public ResponseEntity send_request(@RequestHeader("Authentication-Token") String token,
                                       @RequestBody String receiverUsername) {
        try {
            if (!this.accountService.isUsernameTaken(receiverUsername))
                throw new NotFoundException("Account doesn't exist!");
            String senderUsername = jwtUtils.getUsernameFromToken(token);
            Account sender = this.accountService.findByUsername(senderUsername);
            Account receiver = this.accountService.findByUsername(receiverUsername);

            Friendship f = new Friendship(sender, receiver, FriendshipStatus.AWAITING_FOR_RESPONSE);

            friendshipService.save(f);

            return new ResponseEntity(this.friendshipService.findBySenderAndReciever(sender.getUsername(), receiver.getUsername()), HttpStatus.OK);
        } catch(OptimisticEntityLockException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/api/get_friends",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllFriends(@RequestHeader("Authentication-Token") String token) {
        String username = jwtUtils.getUsernameFromToken(token);
        List<Friendship> friendships = friendshipService.findAllBySender(username);
        ArrayList<AccountDTO> dtos = new ArrayList<>();

        for (Friendship friendship : friendships) {
            if(friendship.getFriendshipStatus() != FriendshipStatus.ACCEPTED)
                continue;
            Account account = friendship.getReceiver();
            dtos.add(new AccountDTO(account));
        }

        friendships = friendshipService.findAllByReceiver(username);
        for (Friendship friendship : friendships) {
            if(friendship.getFriendshipStatus() != FriendshipStatus.ACCEPTED)
                continue;
            Account account = friendship.getSender();
            dtos.add(new AccountDTO(account));
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/get_requests",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRequests(@RequestHeader("Authentication-Token") String token) {
        String receiverUsername = jwtUtils.getUsernameFromToken(token);
        List<Friendship> friendships = friendshipService.findAllByReceiver(receiverUsername);
        ArrayList<AccountDTO> dtos = new ArrayList<>();

        for (Friendship friendship : friendships) {
            if(friendship.getFriendshipStatus() != FriendshipStatus.AWAITING_FOR_RESPONSE)
                continue;
            Account account = friendship.getSender();
            dtos.add(new AccountDTO(account));
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/accept_request",
            method = RequestMethod.POST,
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity accept_request(@RequestHeader("Authentication-Token") String token,
                                         @RequestBody String senderUsername) {
        try {
            String receiverUsername = jwtUtils.getUsernameFromToken(token);
            Account sender = this.accountService.findByUsername(senderUsername);
            Account receiver = this.accountService.findByUsername(receiverUsername);

            Friendship f = friendshipService.findBySenderAndReciever(senderUsername, receiverUsername);
            f.setFriendshipStatus(FriendshipStatus.ACCEPTED);

            friendshipService.save(f);

            return new ResponseEntity(null, HttpStatus.OK);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(
            value = "/api/decline_request",
            method = RequestMethod.POST,
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity decline_request(@RequestHeader("Authentication-Token") String token,
                                          @RequestBody String senderUsername) {
        try {
            String receiverUsername = jwtUtils.getUsernameFromToken(token);
            Account sender = this.accountService.findByUsername(senderUsername);
            Account receiver = this.accountService.findByUsername(receiverUsername);

            Friendship f = friendshipService.findBySenderAndReciever(senderUsername, receiverUsername);
            f.setFriendshipStatus(FriendshipStatus.REJECTED);

            friendshipService.save(f);

            return new ResponseEntity(null, HttpStatus.OK);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/api/remove_friend",
            method = RequestMethod.POST,
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity removeFriend(@RequestHeader("Authentication-Token") String token,
                                       @RequestBody String senderUsername){
        try {
            System.out.println(senderUsername);
            String receiverUsername = jwtUtils.getUsernameFromToken(token);
            System.out.println(receiverUsername);

            Friendship f = friendshipService.findBySenderAndReciever(senderUsername, receiverUsername);

            friendshipService.removeFriend(f.getId());

            return new ResponseEntity(null, HttpStatus.OK);
        }
        catch (OptimisticEntityLockException ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }


}
