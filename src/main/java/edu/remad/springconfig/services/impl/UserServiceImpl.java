package edu.remad.springconfig.services.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserEntityRepository userRepository, RoleRepository rolesRepository,
			PasswordEncoder passwordEncoder) {
		this.userEntityRepository = userRepository;
		this.roleRepository = rolesRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void saveUser(RegistrationDto registrationDto) {
		Role role = roleRepository.findByName("USER");
		UserEntity user = UserEntity
				.builder()
				.username(registrationDto.getUsername())
				.email(registrationDto.getEmail())
				.password(passwordEncoder.encode(registrationDto.getPassword())).enabled(true)
				.roles(Arrays.asList(role)).build();
		userEntityRepository.save(user);
	}

	@Override
	public boolean isUserExisting(String username) {

		UserEntity resultUser = userEntityRepository.findByUsername(username);

		return resultUser == null;
	}

}
