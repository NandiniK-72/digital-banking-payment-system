package com.bank.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private long expiration;

	    private Key getKey() {

	        return Keys.hmacShaKeyFor(
	                secret.getBytes());
	    }
	    
	    public String generateToken(
	            String username) {

	        return Jwts.builder()

	                .subject(username)

	                .issuedAt(
	                        new Date())

	                .expiration(
	                        new Date(
	                                System.currentTimeMillis()
	                                        + expiration))

	                .signWith(
	                        getKey())

	                .compact();
	    }
	    
	    public String extractUsername(
	            String token) {

	        return Jwts.parser()

	                .verifyWith(
	                        (javax.crypto.SecretKey) getKey())

	                .build()

	                .parseSignedClaims(token)

	                .getPayload()

	                .getSubject();
	    }
	    
	    public boolean validateToken(
	            String token) {

	        try {

	            Jwts.parser()
	                    .verifyWith(
	                            (javax.crypto.SecretKey)
	                                    getKey())
	                    .build()
	                    .parseSignedClaims(token);

	            return true;

	        } catch (Exception ex) {

	            return false;
	        }

}
}
