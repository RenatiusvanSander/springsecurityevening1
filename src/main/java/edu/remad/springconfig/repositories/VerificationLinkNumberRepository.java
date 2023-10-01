package edu.remad.springconfig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.remad.springconfig.models.VerificationLinkNumberEntity;

public interface VerificationLinkNumberRepository extends JpaRepository<VerificationLinkNumberEntity, String> {
	VerificationLinkNumberEntity findByEmail(String email);
	VerificationLinkNumberEntity findByVerificationLinkNumber(String verificationLinkNumber);
}
