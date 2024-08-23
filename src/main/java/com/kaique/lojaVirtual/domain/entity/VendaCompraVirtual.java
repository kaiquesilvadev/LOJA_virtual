package com.kaique.lojaVirtual.domain.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

import com.kaique.lojaVirtual.domain.enuns.StatusVendaLojaVirtual;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_venda_compra_virtual")
public class VendaCompraVirtual {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "endereco_entrega_id")
	private Endereco enderecoEntrega;

	@ManyToOne	
	@JoinColumn(name = "endereco_cobranca_id")
	private Endereco enderecoCobranca;
	private BigDecimal valorTotal;
	private BigDecimal valorDesconto;

	@ManyToOne
	@JoinColumn(name = "forma_pagamento_id")
	private FormaPagamento formaPagamento;

	@ManyToOne
	@JoinColumn(name = "nota_fiscal_venda_id")
	private NotaFiscalVenda notaFiscalVenda;

	@ManyToOne
	@JoinColumn(name = "cupom_desconto_id")
	private CupomDesconto cupomDesconto;
	private BigDecimal valorFrete;
	private Integer diasEntrega;
	private Date dataVenda;
	private String urlImprimeEtiqueta;

	@Enumerated(EnumType.STRING)
	private StatusVendaLojaVirtual statusVendaLojaVirtual;

	public VendaCompraVirtual() {
	}

	public VendaCompraVirtual(Long id, Pessoa pessoa, Endereco enderecoEntrega, Endereco enderecoCobranca,
			BigDecimal valorTotal, BigDecimal valorDesconto, FormaPagamento formaPagamento,
			NotaFiscalVenda notaFiscalVenda, CupomDesconto cupomDesconto, BigDecimal valorFrete, Integer diasEntrega,
			Date dataVenda, String urlImprimeEtiqueta, StatusVendaLojaVirtual statusVendaLojaVirtual) {
		this.id = id;
		this.pessoa = pessoa;
		this.enderecoEntrega = enderecoEntrega;
		this.enderecoCobranca = enderecoCobranca;
		this.valorTotal = valorTotal;
		this.valorDesconto = valorDesconto;
		this.formaPagamento = formaPagamento;
		this.notaFiscalVenda = notaFiscalVenda;
		this.cupomDesconto = cupomDesconto;
		this.valorFrete = valorFrete;
		this.diasEntrega = diasEntrega;
		this.dataVenda = dataVenda;
		this.urlImprimeEtiqueta = urlImprimeEtiqueta;
		this.statusVendaLojaVirtual = statusVendaLojaVirtual;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Endereco getEnderecoCobranca() {
		return enderecoCobranca;
	}

	public void setEnderecoCobranca(Endereco enderecoCobranca) {
		this.enderecoCobranca = enderecoCobranca;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public NotaFiscalVenda getNotaFiscalVenda() {
		return notaFiscalVenda;
	}

	public void setNotaFiscalVenda(NotaFiscalVenda notaFiscalVenda) {
		this.notaFiscalVenda = notaFiscalVenda;
	}

	public CupomDesconto getCupomDesconto() {
		return cupomDesconto;
	}

	public void setCupomDesconto(CupomDesconto cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
	}

	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	public Integer getDiasEntrega() {
		return diasEntrega;
	}

	public void setDiasEntrega(Integer diasEntrega) {
		this.diasEntrega = diasEntrega;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getUrlImprimeEtiqueta() {
		return urlImprimeEtiqueta;
	}

	public void setUrlImprimeEtiqueta(String urlImprimeEtiqueta) {
		this.urlImprimeEtiqueta = urlImprimeEtiqueta;
	}

	public StatusVendaLojaVirtual getStatusVendaLojaVirtual() {
		return statusVendaLojaVirtual;
	}

	public void setStatusVendaLojaVirtual(StatusVendaLojaVirtual statusVendaLojaVirtual) {
		this.statusVendaLojaVirtual = statusVendaLojaVirtual;
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
		VendaCompraVirtual other = (VendaCompraVirtual) obj;
		return Objects.equals(id, other.id);
	}
}
