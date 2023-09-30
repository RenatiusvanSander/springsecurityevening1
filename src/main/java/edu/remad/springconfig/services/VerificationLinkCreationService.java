package edu.remad.springconfig.services;

import java.util.Map;

import edu.remad.springconfig.globalexceptions.ErrorInfo;

public interface VerificationLinkCreationService {

	long createVerificationNumber();
	
	String encodeVerificationNumber(long verficationNumber);
	
	boolean storeVerificationLinkNumber(String email, String verificationLink);
	
	Map<String, Object> createVerficationLinkHtml(String email);
	
	ErrorInfo createErrorInfo();
}
