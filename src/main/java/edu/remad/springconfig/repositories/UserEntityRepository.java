package edu.remad.springconfig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.remad.springconfig.models.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, String> {

	UserEntity findByEmail(String email);

	UserEntity findByUsername(String username);

	UserEntity findFirstByUsername(String username);
}
