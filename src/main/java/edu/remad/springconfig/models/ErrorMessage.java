package edu.remad.springconfig.models;

public class ErrorMessage {

	private String code;
	private String email;
	private String localizedMessage;
	private String message;
	private String url;
	private String error;
	private String httpStatus;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocalizedMessage() {
		return localizedMessage;
	}

	public void setLocalizedMessage(String localizedMessage) {
		this.localizedMessage = localizedMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	@Override
	public String toString() {
		return "ErrorMessage [code=" + code + ", email=" + email + ", localizedMessage=" + localizedMessage
				+ ", message=" + message + ", url=" + url + ", error=" + error + ", httpStatus=" + httpStatus + "]";
	}
}
