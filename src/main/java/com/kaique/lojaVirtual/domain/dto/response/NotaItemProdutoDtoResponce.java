package com.kaique.lojaVirtual.domain.dto.response;

import com.kaique.lojaVirtual.domain.dto.referencias.ProdutoDtoRef;
import com.kaique.lojaVirtual.domain.entity.NotaFiscalCompra;
import com.kaique.lojaVirtual.domain.entity.NotaItemProduto;

public class NotaItemProdutoDtoResponce {

	private Long id;
	private Double quantidade;
	private NotaFiscalCompra notaFiscalCompra;
	private ProdutoDtoRef produto;

	public NotaItemProdutoDtoResponce() {
	}

	public NotaItemProdutoDtoResponce(NotaItemProduto notaItemProduto) {
		this.id = notaItemProduto.getId();
		this.quantidade = notaItemProduto.getQuantidade();
		this.notaFiscalCompra = notaItemProduto.getNotaFiscalCompra();
		this.produto = new ProdutoDtoRef(notaItemProduto.getProduto().getId());
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

	public ProdutoDtoRef getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDtoRef produto) {
		this.produto = produto;
	}

}
