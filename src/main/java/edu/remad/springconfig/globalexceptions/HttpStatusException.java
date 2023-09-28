package edu.remad.springconfig.globalexceptions;

import org.springframework.http.HttpStatus;

public interface HttpStatusException {

	String getUrl();

	Error getError();

	String getAdditionalText();

	HttpStatus getHttpStatus();

	String getCode();

	String getTemplate();

	String getEMail();

	String getMessage();

	String getLocalizedMessage();

	ErrorInfo getErrorInfo();
	
	Throwable getCause();
	
	String getNestedErrorMessage();
}
