package com.kaique.lojaVirtual.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kaique.lojaVirtual.domain.entity.PessoaFisica;


public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long>{


	Boolean existsByEmail(String emial);
	
    @Query("SELECT p FROM PessoaFisica p WHERE p.cpf = :cpf")
	Optional<PessoaFisica> buscaCpf(String cpf);
    
    @Query("SELECT p FROM PessoaFisica p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<PessoaFisica> buscaPorNome(String nome);
}
