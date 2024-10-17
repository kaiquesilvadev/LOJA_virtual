package com.kaique.lojaVirtual.domain.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

import com.kaique.lojaVirtual.domain.enuns.StatusContaPagar;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_conta_pagar")
public class ContaPagar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private BigDecimal valortotal;
	private BigDecimal valorDesconto;
	private Date dtVencimento;
	private Date dtPagamento;

	@Enumerated(EnumType.STRING)
	private StatusContaPagar status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_fornecedo_id")
	private PessoaJuridica pessoaFornecedo;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private PessoaJuridica empresa;

	@OneToOne
	@JoinColumn(name = "nota_fiscal_compra_id")
	private NotaFiscalCompra notaFiscalCompra;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	public ContaPagar() {
	}

	public ContaPagar(Long id, String descricao, BigDecimal valortotal, BigDecimal valorDesconto, Date dtVencimento,
			Date dtPagamento, StatusContaPagar status, PessoaJuridica pessoaFornecedo, PessoaJuridica empresa,
			NotaFiscalCompra notaFiscalCompra, Endereco endereco) {
		this.id = id;
		this.descricao = descricao;
		this.valortotal = valortotal;
		this.valorDesconto = valorDesconto;
		this.dtVencimento = dtVencimento;
		this.dtPagamento = dtPagamento;
		this.status = status;
		this.pessoaFornecedo = pessoaFornecedo;
		this.empresa = empresa;
		this.notaFiscalCompra = notaFiscalCompra;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public StatusContaPagar getStatus() {
		return status;
	}

	public void setStatus(StatusContaPagar status) {
		this.status = status;
	}

	public PessoaJuridica getPessoaFornecedo() {
		return pessoaFornecedo;
	}

	public void setPessoaFornecedo(PessoaJuridica pessoaFornecedo) {
		this.pessoaFornecedo = pessoaFornecedo;
	}

	public PessoaJuridica getEmpresa() {
		return empresa;
	}

	public void setEmpresa(PessoaJuridica empresa) {
		this.empresa = empresa;
	}

	public NotaFiscalCompra getNotaFiscalCompra() {
		return notaFiscalCompra;
	}

	public void setNotaFiscalCompra(NotaFiscalCompra notaFiscalCompra) {
		this.notaFiscalCompra = notaFiscalCompra;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		ContaPagar other = (ContaPagar) obj;
		return Objects.equals(id, other.id);
	}
}
