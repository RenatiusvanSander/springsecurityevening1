package edu.remad.springconfig.globalexceptions;

public class ErrorInfo {
	
	private final String url;
	private final Error error;
	private final String additionalText;
	private final String localizedMessage;
	
	public ErrorInfo(String url, Error error, String additionalText, String localizedMessage) {
		this.url = url;
		this.error = error;
		this.additionalText = additionalText;
		this.localizedMessage = localizedMessage;
	}
	
	public String getUrl() {
		return url;
	}

	public Error getError() {
		return error;
	}

	public String getAdditionalText() {
		return additionalText;
	}

	public String getLocalizedMessage() {
		return localizedMessage;
	}
}
