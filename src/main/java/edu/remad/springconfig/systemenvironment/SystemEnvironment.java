package edu.remad.springconfig.systemenvironment;

import java.util.HashMap;
import java.util.Map;

import edu.remad.springconfig.appconstants.DataSourcesAppConstants;
import edu.remad.springconfig.appconstants.SmtpAppConstants;
import edu.remad.springconfig.appconstants.SystemAppConstants;

public class SystemEnvironment {

	private final Map<String, String> properties;

	public SystemEnvironment() {
		this.properties = new HashMap<>();
	}

	public SystemEnvironment(final Map<String, String> properties) {
		this.properties = properties;
	}

	public String getAppAdmin() {
		return properties.get(SystemAppConstants.TUTOR_ADMIN);
	}

	public String getAppAdminPassword() {
		return properties.get(SystemAppConstants.TUTOR_ADMIN_PASSWORD);
	}

	public String getAppUser() {
		return properties.get(SystemAppConstants.TUTOR_USER);
	}

	public String getAppUserPassword() {
		return properties.get(SystemAppConstants.TUTOR_USER_PASSWORD);
	}

	public String getSmtpPassword() {
		return properties.get(SmtpAppConstants.SMTP_USER);
	}

	public String getSmtpUsername() {
		return properties.get(SmtpAppConstants.SMTP_PASSWORD);
	}

	public String getAppDataSourcesMysqlUrl() {
		return properties.get(DataSourcesAppConstants.DATA_SOURCES_MYSQL_URL);
	}

	public String getAppDataSourcesMysqlUsername() {
		return properties.get(DataSourcesAppConstants.DATA_SOURCES_MYSQL_USERNAME);
	}

	public String getAppDataSourcesMysqlPassword() {
		return properties.get(DataSourcesAppConstants.DATA_SOURCES_MYSQL_PASSWORD);
	}
}
