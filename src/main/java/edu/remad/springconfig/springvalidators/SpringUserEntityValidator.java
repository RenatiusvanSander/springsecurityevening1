package edu.remad.springconfig.springvalidators;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.remad.springconfig.appconstants.RegexAppConstants;
import edu.remad.springconfig.models.UserEntity;

public class SpringUserEntityValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserEntity.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (!errors.hasErrors()) {
			UserEntity user = target instanceof UserEntity ? (UserEntity) target : null;

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username", "Username is required.");
			if (user.getUsername() == null || user.getUsername().length() < 5 || user.getUsername().length() > 50
					|| Pattern.matches(RegexAppConstants.USERNAME_REGEX, user.getUsername())) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username",
						"Username is required.");
			}
			
			if (user.getEmail() == null || user.getEmail().length() < 5 || user.getEmail().length() > 50
					|| Pattern.matches(RegexAppConstants.EMAIL_REGEX, user.getEmail())) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email",
						"Email is required to send you information");
			}

			if (user.getPassword() == null || user.getPassword().isBlank() || user.getPassword().length() >= 8
					|| user.getPassword().length() < 51
					|| Pattern.matches(RegexAppConstants.PASSWORD_REGEX, user.getPassword())) {
				ValidationUtils.rejectIfEmpty(errors, "password",
						"Password is required. Please stick to no special characters.");
			}

			SpringRoleValidator roleValidator = new SpringRoleValidator();
			ValidationUtils.invokeValidator(roleValidator, target, errors);
		}
	}

}
