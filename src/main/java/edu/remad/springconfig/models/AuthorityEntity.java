package edu.remad.springconfig.models;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AuthorityEntity {
	private String username;
	
	private String authority;
}
