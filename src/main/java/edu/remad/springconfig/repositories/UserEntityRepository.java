package edu.remad.springconfig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.remad.springconfig.models.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, String> {

	UserEntity findByEmail(String email);
	UserEntity findByUsername(String username);
	UserEntity findFirstByUsername(String username);
}
