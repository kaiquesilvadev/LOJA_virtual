package com.kaique.lojaVirtual.domain.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaique.lojaVirtual.domain.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query("select u from Usuario u join fetch u.acessos where u.login = ?1")
	Optional<Usuario> buscaUserPorLogin(String login);

	Boolean existsByLogin(String emial);
	
	//@Query(value = "select u from Usuario u where u.dataAtuaSenha <= current_date - 90") // consulta PostgreSQL
    //@Query(nativeQuery = true , value = " SELECT * FROM TB_USUARIO WHERE data_atua_senha <= CURRENT_DATE - INTERVAL '90' DAY;")//consulta para h2
	@Query("SELECT u FROM Usuario u WHERE u.dataAtuaSenha <= :cutoffDate")
	List<Usuario> usuarioSenhaVencida(@Param("cutoffDate") LocalDate cutoffDate);
}
