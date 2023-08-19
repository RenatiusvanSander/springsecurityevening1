package edu.remad.springconfig.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class RegistrationDto {
	@NotNull
	private Long id;
	
	@NotEmpty
	@Min(8)
	@Max(50)
	private String username;
	
	@NotEmpty
	@Min(8)
	@Max(50)
	@Email
	private String email;
	
	@NotEmpty
	@Max(50)
	private String password;
}
