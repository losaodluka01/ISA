package ftn.isamrs.tim32.service;

import ftn.isamrs.tim32.model.Account;
import ftn.isamrs.tim32.model.Friendship;
import ftn.isamrs.tim32.repository.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FriendshipServiceImpl implements FriendshipService{

    @Autowired
    private FriendshipRepository friendshipRepository;

    @Autowired
    private AccountService accountService;

    @Override
    @Transactional
    public Friendship save(Friendship f){

        Friendship fs = friendshipRepository.save(f);
        return fs;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Friendship> findAllBySender(String username){
        Account sender = this.accountService.findByUsername(username);
        List<Friendship> flist = this.friendshipRepository.findAllBySender(sender);
        return flist;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Friendship> findAllByReceiver(String username){
        Account sender = this.accountService.findByUsername(username);
        List<Friendship> flist = this.friendshipRepository.findAllByReceiver(sender);
        return flist;
    }

    @Override
    @Transactional(readOnly = true)
    public Friendship findBySenderAndReciever(String senderUsername, String receiverUsername){
        Account sender = this.accountService.findByUsername(senderUsername);
        Account receiver = this.accountService.findByUsername(receiverUsername);
        Friendship friendship = this.friendshipRepository.findBySenderAndReceiver(sender, receiver);
        if(friendship == null)
            friendship = this.friendshipRepository.findBySenderAndReceiver(receiver, sender);
        return friendship;
    }

    @Override
    @Transactional
    public Boolean removeFriend(Long id){

        friendshipRepository.deleteById(id);
        return true;
    }

}
