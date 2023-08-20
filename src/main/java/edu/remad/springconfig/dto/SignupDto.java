package edu.remad.springconfig.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@ToString
public class SignupDto {

	private int id;
	
	private String username;
	
	private String password;
	
	private String repeatedPassword;
	
	private String email;
	
	private String repeatedEmail;
}
