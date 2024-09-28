package com.kaique.lojaVirtual.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kaique.lojaVirtual.domain.entity.MarcaProduto;

public interface MarcaProdutoRepository extends JpaRepository<MarcaProduto, Long>{

	@Query("SELECT m FROM MarcaProduto m WHERE LOWER(m.nomeDesc) = LOWER(:desc)")
    Optional<MarcaProduto> buscaDescricao(String desc);
}
