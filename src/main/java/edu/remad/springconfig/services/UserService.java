package edu.remad.springconfig.services;

import java.util.List;

import edu.remad.springconfig.dto.RegistrationDto;
import edu.remad.springconfig.dto.UserDto;
import edu.remad.springconfig.models.Role;

public interface UserService {
	void saveUser(RegistrationDto registrationDto);
	boolean isUserExisting(String username);
	List<UserDto> getAllUsers();
	void activateUser(String email);
	String[] createRolesArray(List<Role> roles);
}
