package edu.remad.springconfig.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.remad.springconfig.dto.JWTAuthenticationResponseDTO;
import edu.remad.springconfig.dto.LoginDTO;
import edu.remad.springconfig.security.JwtProvider;

@RestController
@RequestMapping("/api/auth")
public class JWTAuthenticationController {

	private AuthenticationManager authenticationManager;
	
	private JwtProvider jwtTokenProvider;
	
	@Autowired
	public JWTAuthenticationController(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
		this.authenticationManager = authenticationManager;
		jwtTokenProvider = jwtProvider;
	}
	
	@PostMapping("login")
	public ResponseEntity<JWTAuthenticationResponseDTO> login(@RequestBody LoginDTO loginDto) {
		UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
		Authentication authentication = authenticationManager.authenticate(userToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtTokenProvider.generateToken(authentication);
		JWTAuthenticationResponseDTO loginResponse = new JWTAuthenticationResponseDTO(token);
		
		return new ResponseEntity<>(loginResponse, HttpStatus.OK);
	}
}
