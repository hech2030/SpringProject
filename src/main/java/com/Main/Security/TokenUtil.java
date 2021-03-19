package com.Main.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtil {

    private final String CLAIMS_Sub = "sub";
    private final String CLAIMS_Cre = "created";

    private Long TOKEN_VALID = 604800L;
    private String TOKEN_SECRET = "SpringProjetApp";


    public String TokenGeneration(UserDetails userDetails){

        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIMS_Sub,userDetails.getUsername());
        claims.put(CLAIMS_Cre,new Date());

        return Jwts.builder().setClaims(claims)
                .setExpiration(GenerateExp())
                .signWith(SignatureAlgorithm.HS512,TOKEN_SECRET).compact();
    }

    public String getUserNameFromToken(String token){
        try{
            return getClaims(token).getSubject();
        }
        catch (Exception ex){
            return null;
        }
    }
    private Date GenerateExp() {
        return new Date(System.currentTimeMillis() + TOKEN_VALID * 1000);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        Date expiration = getClaims(token).getExpiration();
        return expiration.before(new Date());
    }
    private Claims getClaims(String token){
        Claims claims;
        try{
            claims = Jwts.parser().setSigningKey(TOKEN_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        }
        catch (Exception ex){
            claims = null;
        }
        return  claims;
    }
}
