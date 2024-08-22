package com.kaique.lojaVirtual.doman.entity;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cupom_desconto")
public class CupomDesconto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codDesc;
	private BigDecimal valorRealdesc;
	private BigDecimal valorPorcentDesc;

	@ManyToOne(targetEntity = PessoaJuridica.class)
	@JoinColumn(name = "empresa_id")
	private PessoaJuridica empresa;

	public CupomDesconto() {
	}

	public CupomDesconto(Long id, String codDesc, BigDecimal valorRealdesc, BigDecimal valorPorcentDesc,
			PessoaJuridica empresa) {
		this.id = id;
		this.codDesc = codDesc;
		this.valorRealdesc = valorRealdesc;
		this.valorPorcentDesc = valorPorcentDesc;
		this.empresa = empresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodDesc() {
		return codDesc;
	}

	public void setCodDesc(String codDesc) {
		this.codDesc = codDesc;
	}

	public BigDecimal getValorRealdesc() {
		return valorRealdesc;
	}

	public void setValorRealdesc(BigDecimal valorRealdesc) {
		this.valorRealdesc = valorRealdesc;
	}

	public BigDecimal getValorPorcentDesc() {
		return valorPorcentDesc;
	}

	public void setValorPorcentDesc(BigDecimal valorPorcentDesc) {
		this.valorPorcentDesc = valorPorcentDesc;
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
		CupomDesconto other = (CupomDesconto) obj;
		return Objects.equals(id, other.id);
	}

}
