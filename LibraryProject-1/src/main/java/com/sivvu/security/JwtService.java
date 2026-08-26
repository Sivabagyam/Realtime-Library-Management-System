package com.sivvu.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	@Value("${jwt.secret}")
	private String secretKey;
	public String generateToken(String username) {
		 return Jwts.builder()
				   .subject(username)
				   .issuedAt(new Date())
				   .expiration( new Date(System.currentTimeMillis()+86400000))
				   .signWith(getKey())
				   .compact();
	}
	public String extractUsername(String token) {
	    return Jwts.parser()
	            .verifyWith(getKey())
	            .build()
	            .parseSignedClaims(token)
	            .getPayload()
	            .getSubject();
	}
	public boolean isTokenValid (String token,UserDetails userDetails) {
		final String username=extractUsername(token);
		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
		
	}
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	private Date extractExpiration(String token) {
		// TODO Auto-generated method stub
		return Jwts.parser()
				.verifyWith(getKey())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getExpiration();
	}
	private SecretKey getKey() {
		 return Keys.hmacShaKeyFor(
		            Decoders.BASE64.decode(secretKey)
		        );
	}

}
