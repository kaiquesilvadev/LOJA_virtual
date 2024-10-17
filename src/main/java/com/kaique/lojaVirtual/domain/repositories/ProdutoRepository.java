package com.kaique.lojaVirtual.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaique.lojaVirtual.domain.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	
	@Query("SELECT COUNT(ip) FROM Produto p JOIN p.imagemProdutos ip WHERE p.id = :idproduto")
	Integer quantidadeImg(Long  idproduto);
	
	@Query("SELECT EXISTS(SELECT 1 FROM Produto p WHERE p.nome = :nome AND p.empresa.id = :idEmpresa)")
	Boolean existsByNomeAndEmpresa(@Param("nome") String nome, @Param("idEmpresa") Long idEmpresa);

	@Query("SELECT p FROM Produto p JOIN FETCH p.imagemProdutos WHERE p.id = :idProduto")
	Optional<Produto> buscaPorId(Long idProduto);
}
