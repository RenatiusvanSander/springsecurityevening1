package edu.remad.springconfig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.remad.springconfig.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(String name);
}
