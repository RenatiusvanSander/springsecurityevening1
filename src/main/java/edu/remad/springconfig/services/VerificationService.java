package edu.remad.springconfig.services;

import javax.naming.OperationNotSupportedException;

public interface VerificationService {

	boolean saveVerificationNumber(String email, String verficationNumber);
	
	boolean isVerified(String verificationNumber);
	
	void deleteVerification() throws OperationNotSupportedException;

	String getEmail(String verificationNumber);
}
