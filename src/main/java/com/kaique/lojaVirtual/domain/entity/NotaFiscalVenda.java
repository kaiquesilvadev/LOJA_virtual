package com.kaique.lojaVirtual.domain.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Nota_fiscal_venda")
public class NotaFiscalVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	private String serie;
	private String tipo;

	@Column(columnDefinition = "TEXT")
	private String xml;

	@Column(columnDefinition = "TEXT")
	private String pdf;

	@OneToOne
	@JoinColumn(name = "venda_compra_virtual_id")
	private VendaCompraVirtual vendaCompraVirtual;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private PessoaJuridica empresa;

	public NotaFiscalVenda() {
	}

	public NotaFiscalVenda(Long id, String numero, String serie, String tipo, String xml, String pdf,
			VendaCompraVirtual vendaCompraVirtual, PessoaJuridica empresa) {
		this.id = id;
		this.numero = numero;
		this.serie = serie;
		this.tipo = tipo;
		this.xml = xml;
		this.pdf = pdf;
		this.vendaCompraVirtual = vendaCompraVirtual;
		this.empresa = empresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
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
		NotaFiscalVenda other = (NotaFiscalVenda) obj;
		return Objects.equals(id, other.id);
	}

}
