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
@Table(name = "tb_Item_venda_loja")
public class ItemVendaLoja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "venda_compra_virtual_id")
	private VendaCompraVirtual vendaCompraVirtual;
	private Double quantidade;

	public ItemVendaLoja() {
	}

	public ItemVendaLoja(Long id, Produto produto, VendaCompraVirtual vendaCompraVirtual, Double quantidade) {
		this.id = id;
		this.produto = produto;
		this.vendaCompraVirtual = vendaCompraVirtual;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public VendaCompraVirtual getVendaCompraVirtual() {
		return vendaCompraVirtual;
	}

	public void setVendaCompraVirtual(VendaCompraVirtual vendaCompraVirtual) {
		this.vendaCompraVirtual = vendaCompraVirtual;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
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
		ItemVendaLoja other = (ItemVendaLoja) obj;
		return Objects.equals(id, other.id);
	}

}
