package edu.remad.springconfig.services;

import edu.remad.springconfig.dto.RegistrationDto;

public interface UserService {
	void saveUser(RegistrationDto registrationDto);
	boolean isUserExisting(String username);
}
