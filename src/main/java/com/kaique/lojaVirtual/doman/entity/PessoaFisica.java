package com.kaique.lojaVirtual.doman.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoa_fisica")
public class PessoaFisica extends Pessoa{

	private String cpf;
	private Date dataNascimento;
	
	public PessoaFisica() {
	}

	public PessoaFisica(Long id, String nome, String email, String telefone, String cpf, Date dataNascimento) {
		super(id, nome, email, telefone);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
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
}
