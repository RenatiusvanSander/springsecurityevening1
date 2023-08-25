package edu.remad.springconfig.validators.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import edu.remad.springconfig.validators.EqualRepeatedEmailValidator;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { EqualRepeatedEmailValidator.class })
public @interface EqualRepeatedEmail {
	String message() default "{edu.remad.springconfig.validators.annotations.EqualRepeatedEmail}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
