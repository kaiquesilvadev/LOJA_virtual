package com.kaique.lojaVirtual.domain.dto.response;

import com.kaique.lojaVirtual.domain.entity.PessoaJuridica;

public class PessoaFornecedoResponseDto {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cnpj;
	private String nomeFantasia;

	public PessoaFornecedoResponseDto(PessoaJuridica pessoaJuridica) {
		this.id = pessoaJuridica.getId();
		this.nome = pessoaJuridica.getNome();
		this.email = pessoaJuridica.getEmail();
		this.telefone = pessoaJuridica.getTelefone();
		this.cnpj = pessoaJuridica.getCnpj();
		this.nomeFantasia = pessoaJuridica.getNomeFantasia();
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
