package edu.remad.springconfig.globalexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class HttpStatus500Exception extends HttpStatusCodeException implements HttpStatusException {

	private final String message;
	private final ErrorInfo errorInfo;
	private final Throwable cause;

	public HttpStatus500Exception(String message, Throwable cause, ErrorInfo info) {
		super(info.getError().getHttpStatus());
		this.message = message;
		this.cause = cause;
		errorInfo = info;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String getUrl() {
		return errorInfo.getUrl();
	}

	@Override
	public Error getError() {
		return errorInfo.getError();
	}

	@Override
	public String getAdditionalText() {
		return errorInfo.getAdditionalText();
	}

	@Override
	public HttpStatus getHttpStatus() {
		return errorInfo.getError().getHttpStatus();
	}

	@Override
	public String getCode() {
		return errorInfo.getError().getCode();
	}

	@Override
	public String getTemplate() {
		return errorInfo.getError().getTemplate();
	}

	@Override
	public String getEMail() {
		return errorInfo.getError().geteMail();
	}

	@Override
	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	@Override
	public Throwable getCause() {
		return cause;
	}

	@Override
	public String getNestedErrorMessage() {
		return message;
	}
	
	@Override
	public String getMessage() {
		return errorInfo.getError().getMessage();
	}
}
