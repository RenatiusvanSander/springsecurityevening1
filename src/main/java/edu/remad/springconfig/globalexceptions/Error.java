package edu.remad.springconfig.globalexceptions;

import org.springframework.http.HttpStatus;

public enum Error {
	HTTP_500_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"Internal Server Error","ERR_500","api-error", "remad@web.de", "Please contact by errors our support."),
	HTTP_404_ERROR(HttpStatus.NOT_FOUND, "Not found", "ERR_404","api-error", "remad@web.de", "Please contact by errors our support."),
	HTTP_403_ERROR(HttpStatus.FORBIDDEN,"Forbidden","ERR_403","api-error","remad@web.de","Please contact by errors our support."),
	HTTP_401_ERROR(HttpStatus.UNAUTHORIZED,"Unauthorized","ERR_401","api-error","remad@web.de","Please contact by errors our support.");
	
	private final HttpStatus httpStatus;
	private final String error;
	private final String code;
	private final String template;
	private final String eMail;
	private final String message;
	
	Error(HttpStatus internalServerError, String error, String errorCode, String templateFile, String email,
			String supportMessage) {
		httpStatus = internalServerError;
		this.error = error;
		code = errorCode;
		template = templateFile;
		eMail = email;
		message = supportMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getError() {
		return error;
	}

	public String getCode() {
		return code;
	}

	public String getTemplate() {
		return template;
	}

	public String geteMail() {
		return eMail;
	}

	public String getMessage() {
		return message;
	}
}
