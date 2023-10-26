package edu.remad.springconfig.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VerificationLinkNumberEntity {
	
	@Id
	@org.hibernate.validator.constraints.Email
	private String email;
	
	@org.hibernate.validator.constraints.NotBlank
	private String verificationLinkNumber;
}
