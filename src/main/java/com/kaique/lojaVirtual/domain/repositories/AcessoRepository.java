package com.kaique.lojaVirtual.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaique.lojaVirtual.domain.entity.Acesso;

public interface AcessoRepository extends JpaRepository<Acesso, Long>{

	  Optional<Acesso> findByDescricao(String descricao);
}
