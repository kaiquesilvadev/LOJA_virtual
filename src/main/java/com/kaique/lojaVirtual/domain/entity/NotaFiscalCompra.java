package com.kaique.lojaVirtual.domain.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

	@JoinColumn(name = "pessoa_id")
	@ManyToOne
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private PessoaJuridica empresa;

	@OneToMany(mappedBy = "notaFiscalCompra", cascade = CascadeType.REMOVE)
	private List<NotaItemProduto> notaItemProdutos = new ArrayList<>();

	public NotaFiscalCompra() {
	}

	public NotaFiscalCompra(Long id, String numeroNota, String serieNota, String descricaoOds, BigDecimal valorTotal,
			BigDecimal valorDesconto, BigDecimal valorIcms, OffsetDateTime dataCompra, Pessoa pessoa,
			PessoaJuridica empresa) {
		this.id = id;
		this.numeroNota = numeroNota;
		this.serieNota = serieNota;
		this.descricaoOds = descricaoOds;
		this.valorTotal = valorTotal;
		this.valorDesconto = valorDesconto;
		this.valorIcms = valorIcms;
		this.dataCompra = dataCompra;
		this.pessoa = pessoa;
		this.empresa = empresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}

	public String getSerieNota() {
		return serieNota;
	}

	public void setSerieNota(String serieNota) {
		this.serieNota = serieNota;
	}

	public String getDescricaoOds() {
		return descricaoOds;
	}

	public void setDescricaoOds(String descricaoOds) {
		this.descricaoOds = descricaoOds;
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

	public BigDecimal getValorIcms() {
		return valorIcms;
	}

	public void setValorIcms(BigDecimal valorIcms) {
		this.valorIcms = valorIcms;
	}

	public OffsetDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(OffsetDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaJuridica getEmpresa() {
		return empresa;
	}

	public void setEmpresa(PessoaJuridica empresa) {
		this.empresa = empresa;
	}

	public List<NotaItemProduto> getNotaItemProdutos() {
		return notaItemProdutos;
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
		NotaFiscalCompra other = (NotaFiscalCompra) obj;
		return Objects.equals(id, other.id);
	}

}
