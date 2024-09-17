package com.kaique.lojaVirtual.domain.dto.referencias;

import com.kaique.lojaVirtual.domain.entity.PessoaJuridica;

public class EmpresadtoRef {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cnpj;
	private String nomeFantasia;

	public EmpresadtoRef() {
	}

	public EmpresadtoRef(PessoaJuridica pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.telefone = pessoa.getTelefone();
		this.cnpj = pessoa.getCnpj();
		this.nomeFantasia = pessoa.getNomeFantasia();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

}
