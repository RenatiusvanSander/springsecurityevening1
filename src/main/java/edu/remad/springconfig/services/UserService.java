package edu.remad.springconfig.services;

import java.util.List;

import edu.remad.springconfig.dto.RegistrationDto;
import edu.remad.springconfig.dto.UserDto;

public interface UserService {
	void saveUser(RegistrationDto registrationDto);
	boolean isUserExisting(String username);
	List<UserDto> getAllUsers();
	void activateUser(String email);
}
