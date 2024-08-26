package com.kaique.lojaVirtual.domain.entity;

import java.util.Objects;

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
	private VendaCompraVirtual vendaCompraVirtual;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private PessoaJuridica empresa;

	public StatusRastreio() {
	}

	public StatusRastreio(Long id, VendaCompraVirtual vendaCompraVirtual, PessoaJuridica empresa) {
		this.id = id;
		this.vendaCompraVirtual = vendaCompraVirtual;
		this.empresa = empresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VendaCompraVirtual getVendaCompraVirtual() {
		return vendaCompraVirtual;
	}

	public void setVendaCompraVirtual(VendaCompraVirtual vendaCompraVirtual) {
		this.vendaCompraVirtual = vendaCompraVirtual;
	}

	public PessoaJuridica getEmpresa() {
		return empresa;
	}

	public void setEmpresa(PessoaJuridica empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusRastreio other = (StatusRastreio) obj;
		return Objects.equals(id, other.id);
	}

}
