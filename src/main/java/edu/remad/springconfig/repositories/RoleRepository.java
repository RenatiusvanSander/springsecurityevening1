package edu.remad.springconfig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.remad.springconfig.models.AuthorityEntity;

public interface RoleRepository extends JpaRepository<AuthorityEntity, Long>{

}
