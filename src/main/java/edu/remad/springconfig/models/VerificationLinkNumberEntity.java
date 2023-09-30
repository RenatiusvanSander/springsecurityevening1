package edu.remad.springconfig.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

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
	@NotEmpty
	private String email;
	
	@org.hibernate.validator.constraints.NotBlank
	private String verificationLinkNumber;
}
