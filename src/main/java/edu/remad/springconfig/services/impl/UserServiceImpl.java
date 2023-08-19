package edu.remad.springconfig.services.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.remad.springconfig.dto.RegistrationDto;
import edu.remad.springconfig.models.Role;
import edu.remad.springconfig.models.UserEntity;
import edu.remad.springconfig.repositories.RoleRepository;
import edu.remad.springconfig.repositories.UserEntityRepository;
import edu.remad.springconfig.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserEntityRepository userEntityRepository;
	
	private RoleRepository roleRepository;
	
	@Autowired
	public UserServiceImpl(UserEntityRepository userRepository, RoleRepository rolesRepository) {
		this.userEntityRepository = userRepository;
		this.roleRepository = rolesRepository;
	}
	
	@Override
	public void saveUser(RegistrationDto registrationDto) {
		UserEntity user = new UserEntity();
		
		user.setUsername(registrationDto.getUsername);
		user.setEmail(registrationDto.getEmail());
		user.setPassword(registrationDto.getPassword());
		
		Role role = roleRepository.findByName("USER");
		user.setRoles(Arrays.asList(role));
		
		userEntityRepository.save(user);
	}

}
