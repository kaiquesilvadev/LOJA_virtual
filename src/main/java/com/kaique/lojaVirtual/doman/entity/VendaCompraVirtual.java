package com.kaique.lojaVirtual.doman.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

import com.kaique.lojaVirtual.doman.enuns.StatusVendaLojaVirtual;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_venda_compra_virtual")
public class VendaCompraVirtual {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Pessoa pessoa;

	@ManyToOne
	private Endereco enderecoEntrega;

	@ManyToOne
	private Endereco enderecoCobranca;

	private BigDecimal valortotal;
	private BigDecimal valorDesconto;

	@ManyToOne
	private FormaPagamento formaPagamento;

	@ManyToOne
	private NotaFiscalVenda notaFiscalVenda;

	@ManyToOne
	private CupomDesconto cupomDesconto;

	private BigDecimal valorfrete;
	private Integer diasentrega;
	private Date dataVenda;
	private String urlImprimeEtiqueta;

	@Enumerated(EnumType.STRING)
	private StatusVendaLojaVirtual statusVendaLojaVirtual;

	public VendaCompraVirtual() {
	}

	public VendaCompraVirtual(Long id, Pessoa pessoa, Endereco enderecoEntrega, Endereco enderecoCobranca,
			BigDecimal valortotal, BigDecimal valorDesconto, FormaPagamento formaPagamento,
			NotaFiscalVenda notaFiscalVenda, CupomDesconto cupomDesconto, BigDecimal valorfrete, Integer diasentrega,
			Date dataVenda, String urlImprimeEtiqueta, StatusVendaLojaVirtual statusVendaLojaVirtual) {
		this.id = id;
		this.pessoa = pessoa;
		this.enderecoEntrega = enderecoEntrega;
		this.enderecoCobranca = enderecoCobranca;
		this.valortotal = valortotal;
		this.valorDesconto = valorDesconto;
		this.formaPagamento = formaPagamento;
		this.notaFiscalVenda = notaFiscalVenda;
		this.cupomDesconto = cupomDesconto;
		this.valorfrete = valorfrete;
		this.diasentrega = diasentrega;
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

	public BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
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

	public BigDecimal getValorfrete() {
		return valorfrete;
	}

	public void setValorfrete(BigDecimal valorfrete) {
		this.valorfrete = valorfrete;
	}

	public Integer getDiasentrega() {
		return diasentrega;
	}

	public void setDiasentrega(Integer diasentrega) {
		this.diasentrega = diasentrega;
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
