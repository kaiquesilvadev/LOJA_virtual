package com.kaique.lojaVirtual.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kaique.lojaVirtual.domain.entity.PessoaJuridica;


public interface PessoaRepository extends JpaRepository<PessoaJuridica, Long>{


	Boolean existsByEmail(String emial);
	
    @Query("SELECT p FROM PessoaJuridica p WHERE p.cnpj = :cnpj")
	Optional<PessoaJuridica> cnpjExistente(String cnpj);
}
