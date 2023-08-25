package edu.remad.springconfig.validators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.remad.springconfig.appconstants.RegexAppConstants;
import edu.remad.springconfig.dto.SignupDto;
import edu.remad.springconfig.validators.annotations.EqualRepeatedEmail;

public class EqualRepeatedEmailValidator implements ConstraintValidator<EqualRepeatedEmail, SignupDto> {

	@Override
	public boolean isValid(SignupDto value, ConstraintValidatorContext context) {
		if (value == null || value.getEmail().isBlank() || value.getRepeatedEmail().isBlank()
				|| value.getEmail().length() <= 7 || value.getRepeatedEmail().length() <= 7
				|| value.getEmail().length() > 500 || value.getRepeatedEmail().length() > 500
				|| !Pattern.matches(RegexAppConstants.EMAIL_REGEX, value.getEmail())
				|| !Pattern.matches(RegexAppConstants.EMAIL_REGEX, value.getRepeatedEmail())) {
			return false;
		}

		return value.getEmail().equals(value.getRepeatedEmail());
	}
}
