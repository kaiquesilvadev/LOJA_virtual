package com.kaique.lojaVirtual.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.lojaVirtual.domain.entity.ImagemProduto;

public interface ImagemProdutoRepository extends JpaRepository<ImagemProduto, Long> {
	
	@Modifying
	@Transactional
	@Query("DELETE FROM ImagemProduto i WHERE i.produto.id = :idProduto")
	void deletaTodaImgPorIdProduto(Long idProduto);
}
