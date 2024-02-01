package com.example.config;

import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtProvider {
    
    private SecretKey key =Keys.hmacShaKeyFor(JwtConstant.JWT_SECRET.getBytes());


    public String generateToken(Authentication auth) {
        
        String jwt=Jwts.builder()
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime()+86400000))
                    .claim("email", auth.getName())
                    .signWith(key).compact();


        return jwt;
    }

    public String getEmailFromJwtToken(String jwt) {

        jwt=jwt.substring(7);
        Claims claims = Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(jwt)
                        .getBody();

;
        String email = String.valueOf(claims.get("email"));

        System.out.println("JWT Claims:");
            for (Map.Entry<String, Object> entry : claims.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }


        return email;
    }

}
