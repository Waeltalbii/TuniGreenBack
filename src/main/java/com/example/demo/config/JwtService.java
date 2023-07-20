package com.example.demo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Component

public class JwtService {
    private static final String SECRET_KEY = "MHcCAQEEINgFbBZSv+9QO/DpTp/buy8RyPpACvMq9JxzL9p8iWEAoAoGCCqGSM49AwEHoUQDQgAEm+Ik0pTFlqTmXNQ9hxn+bZ6s1xKxMhF3CAmQgP7kveFPq1sF+8n5Lmij+FRU5L++7gB4+3hq5USjUJdPr4z38Q==";
    public String extractUseremail(String token) {
        return extractClaims(token,Claims::getSubject) ;
    }
    public boolean isTokenValid(String token ,UserDetails userDetails){
        final  String username = extractUseremail(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return  extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token,Claims::getExpiration);
    }

    public String generateTokenn(UserDetails userDetails){
        System.out.println(userDetails);
        return generateToken(new HashMap<>(),userDetails);
    }
    public String generateToken(Map<String,Object> extractClaims,
                                UserDetails userDetails){
        return  Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
            /*    .signWith(getSignInKey(), SignatureAlgorithm.ES256)*/
                .compact();
    }
    public <T> T extractClaims(String token, Function<Claims,T> claimsResolver){
        final  Claims claims = extractAllClaims(token);
        return  claimsResolver.apply(claims);
    }
    public Claims extractAllClaims(String token){
        return Jwts.
                parserBuilder()
                .setSigningKey(getSignInKey())

                .build()
                .parseClaimsJws(token).
                getBody();
    }

    private Key getSignInKey() {
      byte[] keybytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keybytes);
    }


}
