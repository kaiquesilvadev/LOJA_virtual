package com.kaique.lojaVirtual.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kaique.lojaVirtual.domain.entity.CategoriaProduto;
import com.kaique.lojaVirtual.domain.entity.PessoaJuridica;

public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {

	@Query("SELECT c FROM CategoriaProduto c WHERE LOWER(c.nomeDesc) = LOWER(:nomeDesc) AND c.empresa = :empresa")
	Optional<CategoriaProduto> buscaDescricaoPorEmpresa(String nomeDesc , PessoaJuridica empresa);

}
