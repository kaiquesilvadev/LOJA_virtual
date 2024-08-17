package com.kaique.lojaVirtual.doman.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_nota_fiscal_compra")
public class NotaFiscalCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String numeroNota;
	private String serieNota;
	private String descricaoOds;
	private BigDecimal valorTotal;
	private BigDecimal valorDesconto;
	private BigDecimal valorIcms;
	
	@CreationTimestamp
	private OffsetDateTime dataCompra;
	
	@ManyToOne
	private Pessoa pessoa;
	
}
