package edu.remad.springconfig.systemenvironment;

import java.util.Map;

import javax.naming.OperationNotSupportedException;

import edu.remad.springconfig.appconstants.SmtpAppConstants;
import edu.remad.springconfig.appconstants.SystemAppConstants;

public final class SystemEnvironmentFactory {
	private static SystemEnvironment SYSTEM_ENVIRONMENT;
    private static String info = "System environment properties for this app";
    
    private SystemEnvironmentFactory() throws OperationNotSupportedException {
    	throw new OperationNotSupportedException("You shall not craete such instance!");
    }
    
    public static SystemEnvironment getInstance() {
        if(SYSTEM_ENVIRONMENT == null) {
        	SYSTEM_ENVIRONMENT = createSystemEnvironment();
        }
        
        return SYSTEM_ENVIRONMENT;
    }
    
    private static SystemEnvironment createSystemEnvironment() {
    	Map<String,String> systemVaries = System.getenv();
    	SystemEnvironment systemEnvironment = new SystemEnvironment();
    	
    	if(systemVaries != null && !systemVaries.isEmpty()) {
    		String adminUser = systemVaries.get(SystemAppConstants.TUTOR_ADMIN);
    		String adminPassword = systemVaries.get(SystemAppConstants.TUTOR_ADMIN_PASSWORD);
    		String appUser = systemVaries.get(SystemAppConstants.TUTOR_USER);
    		String appUserPassword = systemVaries.get(SystemAppConstants.TUTOR_USER_PASSWORD);
    		String smtpUsername = systemVaries.get(SmtpAppConstants.SMTP_USER);
    		String smtpPassword = systemVaries.get(SmtpAppConstants.SMTP_PASSWORD);
    		
    		systemEnvironment = new SystemEnvironment(adminUser, adminPassword, appUser, appUserPassword, smtpUsername, smtpPassword);
    	}
    	
    	return systemEnvironment;
    }
    
    public static String getInfo() {
    	return info;
    }
}
