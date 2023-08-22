package edu.remad.springconfig.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RegistrationDto {
	
	@NotBlank
//	@Min(8)
//	@Max(50)
	private String username;
	
	@NotBlank
	@Min(8)
	@Max(50)
	@Email
	private String email;
	
	@NotBlank
	@Min(8)
	@Max(500)
	private String password;
}
