package com.kaique.lojaVirtual.domain.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaique.lojaVirtual.domain.entity.ContaPagar;

public interface ContaPagarRepository extends JpaRepository<ContaPagar, Long> {

	@Query("SELECT c FROM ContaPagar c JOIN FETCH c.empresa e WHERE c.dtVencimento = :oneDayAhead OR c.dtVencimento = :twoDaysAhead")
	List<ContaPagar> findContasProximasVencimento(@Param("oneDayAhead") Date oneDayAhead, @Param("twoDaysAhead") Date twoDaysAhead);

}
