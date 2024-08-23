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
@Table(name = "tb_nota_fiscal_compra")
public class NotaItemProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double quantidade;

	@JoinColumn(name = "nota_fiscal_compra_id")
	@ManyToOne
	private NotaFiscalCompra notaFiscalCompra;

	@JoinColumn(name = "produto_id")
	@ManyToOne
	private Produto produto;

	public NotaItemProduto() {
	}

	public NotaItemProduto(Long id, Double quantidade, NotaFiscalCompra notaFiscalCompra, Produto produto) {
		this.id = id;
		this.quantidade = quantidade;
		this.notaFiscalCompra = notaFiscalCompra;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public NotaFiscalCompra getNotaFiscalCompra() {
		return notaFiscalCompra;
	}

	public void setNotaFiscalCompra(NotaFiscalCompra notaFiscalCompra) {
		this.notaFiscalCompra = notaFiscalCompra;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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
		NotaItemProduto other = (NotaItemProduto) obj;
		return Objects.equals(id, other.id);
	}

}
