package edu.remad.springconfig.security;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import edu.remad.springconfig.appconstants.SecurityAppConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {

	public String generateToken(Authentication authentication) {
		String userName = authentication.getName();
		Date currentDate = new Date();
		Date expireDate = new Date(currentDate.getTime() + SecurityAppConstants.JWT_EXPIRATION_IN_MS);

		String jwtToken = Jwts.builder().subject(userName).issuedAt(new Date()).expiration(expireDate)
				.signWith(SignatureAlgorithm.HS512, SecurityAppConstants.JWT_SECRET).compact();

		return jwtToken;
	}

	public String getUsernameFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(SecurityAppConstants.JWT_SECRET).build().parseClaimsJws(token)
				.getBody();
		String username = claims.getSubject();

		return username;
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(SecurityAppConstants.JWT_SECRET).build().parseClaimsJws(token);
			
			return true;
		} catch (Exception ex) {
			throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
		}
	}
}
