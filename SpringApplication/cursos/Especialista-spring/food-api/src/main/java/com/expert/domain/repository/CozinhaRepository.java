package com.expert.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.expert.domain.model.Cozinha;


@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

//	List<Cozinha> consultarPorNome(String nome);
	
}
