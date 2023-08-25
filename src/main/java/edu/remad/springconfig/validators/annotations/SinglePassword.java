package edu.remad.springconfig.validators.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import edu.remad.springconfig.validators.SinglePasswordValidator;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= {SinglePasswordValidator.class})
public @interface SinglePassword {
	
	String message() default "{edu.remad.springconfig.validators.annotations.SinglePassword}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
