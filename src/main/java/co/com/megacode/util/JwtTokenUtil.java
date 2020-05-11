package co.com.megacode.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static co.com.megacode.constant.JwtConstant.*;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -25478987627347488L;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.ignore.expiration}")
    private String ignoreExpiration;

    public String generateToken(UserDetails userDetails, HashMap claims) {
        return doGenerateToken(claims, userDetails.getUsername());
    }

    public String generateToken(HashMap claims) {
        return doGenerateToken(claims);
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TIME_MS_EXPIRATION_TOKEN))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    private String doGenerateToken(Map<String, Object> claims) {

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + CONFIRM_USER_TIME_MS_EXPIRATION_TOKEN))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public Boolean isTokenExpired(String token) {
        if(ignoreTokenExpiration())
            return false;

        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean ignoreTokenExpiration() {
        return Boolean.valueOf(ignoreExpiration);
    }

    public Boolean canTokenBeRefreshed(String token) {
        return (!isTokenExpired(token) || ignoreTokenExpiration());
    }

    public Boolean validateToken(String token, UserDetails userDetails, Long idUser) {
        final String username = getUsernameFromToken(token);
        Claims claims = getAllClaimsFromToken(token);
        Long id = Long.parseLong(claims.get(ID_CLAIMS_MAP, String.class));

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token) && idUser == id);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
}