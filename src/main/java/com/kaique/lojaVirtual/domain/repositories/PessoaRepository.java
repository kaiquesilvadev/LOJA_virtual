package com.kaique.lojaVirtual.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kaique.lojaVirtual.domain.entity.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	@Query("select p from Pessoa p join fetch p.enderecos where p.id = ?1")
	Pessoa BuscaPsEndereco(Long id);
}
