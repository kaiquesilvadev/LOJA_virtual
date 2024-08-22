package com.kaique.lojaVirtual.doman.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

import com.kaique.lojaVirtual.doman.enuns.StatusContaReceber;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_conta_receber")
public class ContaReceber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String drescricao;
	private StatusContaReceber status;
	private Date dtVencimento;
	private Date dtPagamento;
	private BigDecimal valortotal;
	private BigDecimal valorDescontos;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Pessoa empresa;

	public ContaReceber() {
	}

	public ContaReceber(Long id, String drescricao, StatusContaReceber status, Date dtVencimento, Date dtPagamento,
			BigDecimal valortotal, BigDecimal valorDescontos, Pessoa pessoa, Pessoa empresa) {
		this.id = id;
		this.drescricao = drescricao;
		this.status = status;
		this.dtVencimento = dtVencimento;
		this.dtPagamento = dtPagamento;
		this.valortotal = valortotal;
		this.valorDescontos = valorDescontos;
		this.pessoa = pessoa;
		this.empresa = empresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDrescricao() {
		return drescricao;
	}

	public void setDrescricao(String drescricao) {
		this.drescricao = drescricao;
	}

	public StatusContaReceber getStatus() {
		return status;
	}

	public void setStatus(StatusContaReceber status) {
		this.status = status;
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

	public BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public BigDecimal getValorDescontos() {
		return valorDescontos;
	}

	public void setValorDescontos(BigDecimal valorDescontos) {
		this.valorDescontos = valorDescontos;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Pessoa empresa) {
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
		ContaReceber other = (ContaReceber) obj;
		return Objects.equals(id, other.id);
	}

}
