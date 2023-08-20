package edu.remad.springconfig.services.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.remad.springconfig.models.UserEntity;
import edu.remad.springconfig.repositories.UserEntityRepository;

@Service
public class CustomJpaUserDetailsService implements UserDetailsService {

	private UserEntityRepository userEntityRepository;

	@Autowired
	public CustomJpaUserDetailsService(UserEntityRepository userEntityRepository) {
		this.userEntityRepository = userEntityRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userEntityRepository.findFirstByUsername(username);

		System.out.println("##### User is " + user);
		
		if (user != null) {
			User authUser = new User(user.getUsername(), user.getPassword(), user.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
			
			return authUser;
		} else {
			throw new UsernameNotFoundException("Username is not found: " + username);
		}
	}
}
