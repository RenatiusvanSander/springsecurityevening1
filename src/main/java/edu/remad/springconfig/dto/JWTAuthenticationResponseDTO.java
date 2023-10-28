package edu.remad.springconfig.dto;

import lombok.Data;

@Data
public class JWTAuthenticationResponseDTO {

	private String jwtAccessToken;
	private String tokenType = "Bearer ";
	
	public JWTAuthenticationResponseDTO(String jwtAccessToken) {
		this.jwtAccessToken = jwtAccessToken;
	}
}
