package edu.remad.springconfig.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.remad.springconfig.models.VerificationLinkNumberEntity;
import edu.remad.springconfig.repositories.VerificationLinkNumberRepository;
import edu.remad.springconfig.services.VerificationService;

@Service
public class VerificationServiceImpl implements VerificationService {

	private final VerificationLinkNumberRepository verificationLinkNumberRepository;
	public static final String VERIFICATION_NUMBER_KEY = "VERIFICATION_NUMBER_KEY";

	@Autowired
	public VerificationServiceImpl(VerificationLinkNumberRepository verificationLinkNumberRepository) {
		this.verificationLinkNumberRepository = verificationLinkNumberRepository;
	}

	@Override
	public boolean saveVerificationNumber(String email, String verficationNumber) {
		if(verificationLinkNumberRepository.existsById(email)) {
			return false;
		}
		
		VerificationLinkNumberEntity verificationLinkNumberEntity = new VerificationLinkNumberEntity(email, verficationNumber);
		VerificationLinkNumberEntity savedVerificationLinkNumberEntity = verificationLinkNumberRepository.saveAndFlush(verificationLinkNumberEntity);

		return !savedVerificationLinkNumberEntity.getEmail().isBlank() && !savedVerificationLinkNumberEntity.getVerificationLinkNumber().isBlank();
	}

	@Override
	public boolean isVerified(String verificationNumber) {
		VerificationLinkNumberEntity verificationLinkNumber = verificationLinkNumberRepository.findByVerificationLinkNumber(verificationNumber);
		
		if(verificationLinkNumber == null) {
			return false;
		}
		
		boolean isVerfied = verificationLinkNumber.getVerificationLinkNumber().equals(verificationNumber);

		return isVerfied;
	}

	@Override
	public void deleteVerification(String email) {
		verificationLinkNumberRepository.deleteById(email);
	}

	@Override
	public String getEmail(String verificationNumber) {
		VerificationLinkNumberEntity verificationLinkNumber = verificationLinkNumberRepository.findByVerificationLinkNumber(verificationNumber);
		String email = verificationLinkNumber.getEmail();
		
		return email;
	}
}
