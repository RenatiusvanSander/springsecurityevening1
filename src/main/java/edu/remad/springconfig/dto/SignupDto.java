package edu.remad.springconfig.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SignupDto {

	private int id;
	
	private String username;
	
	private String password;
	
	private String repeatedPassword;
	
	private String email;
	
	private String repeatedEmail;
}
