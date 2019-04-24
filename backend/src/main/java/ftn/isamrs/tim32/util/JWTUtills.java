package ftn.isamrs.tim32.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtills {

    @Value("myXAuthSecret")
    private String secret;

    @Value("18000") //in seconds (5 hours)
    private Long expiration;

    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = this.getClaimsFromToken(token);
            if (claims != null)
                username = claims.getSubject();
            else
                username = null;
        } catch (Exception e) {
            username = null;
        }
        return username;


    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(this.secret)
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }
}
