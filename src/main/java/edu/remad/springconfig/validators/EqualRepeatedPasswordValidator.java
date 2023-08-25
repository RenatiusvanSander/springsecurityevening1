package edu.remad.springconfig.validators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.remad.springconfig.appconstants.RegexAppConstants;
import edu.remad.springconfig.dto.SignupDto;
import edu.remad.springconfig.validators.annotations.EqualRepeatedPasswords;

public class EqualRepeatedPasswordValidator implements ConstraintValidator<EqualRepeatedPasswords, SignupDto> {

	@Override
	public boolean isValid(SignupDto value, ConstraintValidatorContext context) {
		if (value == null || value.getPassword().isBlank() || value.getRepeatedPassword().isBlank()
				|| value.getPassword().length() <= 7 || value.getRepeatedPassword().length() <= 7
				|| value.getPassword().length() > 500 || value.getRepeatedPassword().length() > 500
				|| !Pattern.matches(RegexAppConstants.PASSWORD_REGEX, value.getPassword())
				|| !Pattern.matches(RegexAppConstants.PASSWORD_REGEX, value.getRepeatedPassword())) {
			return false;
		}

		return value.getPassword().equals(value.getRepeatedPassword());
	}
}
