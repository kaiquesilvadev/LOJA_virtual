package com.kaique.lojaVirtual.domain.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoa_fisica")
public class PessoaFisica extends Pessoa {

	private String cpf;
	private Date dataNascimento;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private PessoaJuridica empresa;

	public PessoaFisica() {
	}

	public PessoaFisica(String cpf, Date dataNascimento, PessoaJuridica empresa) {
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.empresa = empresa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public PessoaJuridica getEmpresa() {
		return empresa;
	}

	public void setEmpresa(PessoaJuridica empresa) {
		this.empresa = empresa;
	}

}
