package edu.remad.springconfig.dto;

import edu.remad.springconfig.validators.annotations.SinglePassword;
import edu.remad.springconfig.validators.annotations.ValidUsername;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignupDto {
	
	@ValidUsername
	private String username;
	
	@SinglePassword
	private String password;
	
	@SinglePassword
	private String repeatedPassword;
	
	private String email;
	
	private String repeatedEmail;
}
