package com.kaique.lojaVirtual.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_status_rastreio")
public class StatusRastreio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "venda_compra_virtual_id")
	private  VendaCompraVirtual vendaCompraVirtual;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private PessoaJuridica empresa;
}
