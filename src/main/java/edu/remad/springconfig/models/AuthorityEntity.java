package edu.remad.springconfig.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorityEntity {
	
	private Long id;
	
	private String username;
	
	private String authority;
}
