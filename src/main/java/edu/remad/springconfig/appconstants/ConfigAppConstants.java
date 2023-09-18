package edu.remad.springconfig.appconstants;

public final class ConfigAppConstants {
	private ConfigAppConstants() {
	}

	private static final String[] CONFIG_PROPERTIES = new String[] { SystemAppConstants.TUTOR_ADMIN,
			SystemAppConstants.TUTOR_ADMIN_PASSWORD, SystemAppConstants.TUTOR_USER,
			SystemAppConstants.TUTOR_USER_PASSWORD, SmtpAppConstants.SMTP_USER, SmtpAppConstants.SMTP_PASSWORD,
			DataSourcesAppConstants.DATA_SOURCES_MYSQL_URL, DataSourcesAppConstants.DATA_SOURCES_MYSQL_USERNAME,
			DataSourcesAppConstants.DATA_SOURCES_MYSQL_PASSWORD };

	public static String[] getConfigProperties() {
		return CONFIG_PROPERTIES;
	}
}
