package edu.remad.springconfig.systemenvironment;

public class SystemEnvironment {

	private final String appAdmin;
	private final String appAdminPassword;
	private final String appUser;
	private final String appUserPassword;
	private final String smtpPassword;
	private final String smtpUsername;

	public SystemEnvironment() {
		this.appAdmin = "";
		this.appAdminPassword = "";
		this.appUser = "";
		this.appUserPassword = "";
		this.smtpPassword = "";
		this.smtpUsername = "";

	}

	public SystemEnvironment(final String adminUser, final String adminPassword, final String appUser,
			final String appUserPassword, final String smtpUsername, final String smtpPassword) {
		appAdmin = adminUser;
		appAdminPassword = appUserPassword;
		this.appUser = appUser;
		this.appUserPassword = appUserPassword;
		this.smtpUsername = smtpUsername;
		this.smtpPassword = smtpPassword;
	}

	public String getAppAdmin() {
		return appAdmin;
	}

	public String getAppAdminPassword() {
		return appAdminPassword;
	}

	public String getAppUser() {
		return appUser;
	}

	public String getAppUserPassword() {
		return appUserPassword;
	}

	public String getSmtpPassword() {
		return smtpPassword;
	}

	public String getSmtpUsername() {
		return smtpUsername;
	}
}
