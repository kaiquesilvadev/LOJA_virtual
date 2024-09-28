package com.kaique.lojaVirtual.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaique.lojaVirtual.domain.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	@Query("select e from Pessoa p join p.enderecos e where p.id = :idPessoa and e.id = :idEndereco")
	Endereco buscaEnderecoPorPessoa(@Param("idPessoa") Long idPessoa, @Param("idEndereco") Long idEndereco);

}
