package edu.remad.springconfig.services.impl;

import javax.naming.OperationNotSupportedException;

import org.springframework.stereotype.Service;

import edu.remad.springconfig.services.VerificationService;

@Service
public class VerificationServiceImpl implements VerificationService {

	// TODO verificationNumberRepo
	
	@Override
	public boolean saveVerificationNumber(String email, String verficationNumber) {
		return false;
	}

	@Override
	public boolean isVerified() {
		return false;
	}

	@Override
	public void deleteVerification() throws OperationNotSupportedException {
		throw new OperationNotSupportedException("This method is not supported: deleteVerification.");
	}
}
