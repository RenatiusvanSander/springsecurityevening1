package edu.remad.springconfig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.remad.springconfig.models.TokenEntity;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, Long>{
	

}
