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
public class SignupDto {
	
	private String username;
	
	private String password;
	
	private String repeatedPassword;
	
	private String email;
	
	private String repeatedEmail;
}
