package edu.remad.springconfig.appconstants;

public final class RegexAppConstants {

	public final static String EMAIL_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
	+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	public final static String PASSWORD_REGEX = "[0-9a-zA-Z]*";
	public final static String USERNAME_REGEX = "[0-9_a-zA-Z]*";

	private RegexAppConstants() {
		throw new UnsupportedOperationException(this.getClass().getName() +  " shall not be supported.");
	}
}
