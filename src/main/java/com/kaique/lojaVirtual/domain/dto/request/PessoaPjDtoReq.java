package com.kaique.lojaVirtual.domain.dto.request;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PessoaPjDtoReq {

	@NotBlank
	private String nome;
	
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 11 , min = 10)
	private String telefone;
	
	@CNPJ
	private String cnpj;
	
	@NotBlank
	private String inscEstadual;
	
	@NotBlank
	private String inscMunicipal;
	
	@NotBlank
	private String nomeFantasia;
	
	@NotBlank
	private String razaoSocial;
	
	@Valid
	@Size(min = 1)
	private List<EnderecoRequestDto> endereco = new ArrayList<>();
	
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
	public String getInscEstadual() {
		return inscEstadual;
	}
	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}
	public String getInscMunicipal() {
		return inscMunicipal;
	}
	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public List<EnderecoRequestDto> getEndereco() {
		return endereco;
	}
}
