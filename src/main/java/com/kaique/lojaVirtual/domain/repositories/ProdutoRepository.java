package com.kaique.lojaVirtual.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kaique.lojaVirtual.domain.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	
	@Query("SELECT COUNT(ip) FROM Produto p JOIN p.imagemProdutos ip WHERE p.id = :idproduto")
	Integer quantidadeImg(Long  idproduto);
}
