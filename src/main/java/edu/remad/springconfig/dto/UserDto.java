package edu.remad.springconfig.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {
	
private String username;
	
	private String email;
	
	private String password;
	
	private Boolean enabled;
	
	private String[] roles;
}
