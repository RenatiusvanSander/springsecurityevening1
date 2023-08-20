package edu.remad.springconfig.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.remad.springconfig.dto.SignupDto;
import edu.remad.springconfig.validators.annotations.EqualRepeatedPasswords;

public class EqualRepeatedPasswordValidator implements ConstraintValidator<EqualRepeatedPasswords, SignupDto> {
	
	@Override
	public boolean isValid(SignupDto value, ConstraintValidatorContext context) {
		return value.getPassword().equals(value.getRepeatedPassword());
	}

}
