package edu.remad.springconfig.systemenvironment;

import java.util.HashMap;
import java.util.Map;

import javax.naming.OperationNotSupportedException;

import edu.remad.springconfig.appconstants.ConfigAppConstants;
import edu.remad.springconfig.appconstants.DataSourcesAppConstants;
import edu.remad.springconfig.appconstants.SmtpAppConstants;
import edu.remad.springconfig.appconstants.SystemAppConstants;

public final class SystemEnvironmentFactory {
	private static SystemEnvironment SYSTEM_ENVIRONMENT;
	private static String info = "System environment properties for this app";

	private SystemEnvironmentFactory() throws OperationNotSupportedException {
		throw new OperationNotSupportedException("You shall not craete such instance!");
	}

	public static SystemEnvironment getInstance() {
		if (SYSTEM_ENVIRONMENT == null) {
			SYSTEM_ENVIRONMENT = createSystemEnvironment();
		}

		return SYSTEM_ENVIRONMENT;
	}

	private static SystemEnvironment createSystemEnvironment() {
		Map<String, String> systemVaries = System.getenv();
		SystemEnvironment systemEnvironment = createAndPopulateProperties(systemVaries);

		return systemEnvironment;
	}

	private static SystemEnvironment createAndPopulateProperties(Map<String, String> systemVaries) {
		SystemEnvironment systemEnvironment = new SystemEnvironment();
		
		if (systemVaries != null && !systemVaries.isEmpty()) {
			Map<String, String> properties = new HashMap<>();
			
			for(String configProperty : ConfigAppConstants.getConfigProperties()) {
				properties.put(configProperty, systemVaries.get(configProperty));
			}

			systemEnvironment = new SystemEnvironment(properties);
		}
		
		return systemEnvironment;
	}

	public static String getInfo() {
		return info;
	}
}
