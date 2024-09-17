package com.kaique.lojaVirtual.domain.dto.request;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class PessoaFsUserDtoReq {

	@NotBlank
	private String nome;
	
	@Email
	private String email;
	
	@NotBlank
	private String telefone;
	
	@CPF
	private String cpf;
	
	@PastOrPresent 
	private Date dataNascimento;
	
	@Valid
	@Size(min = 1)
	List<EnderecoRequestDto> enderecos = new ArrayList<>();

	public PessoaFsUserDtoReq() {
	}

	public PessoaFsUserDtoReq( String nome, String email, String telefone, String cpf, Date dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
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

	public List<EnderecoRequestDto> getEnderecos() {
		return enderecos;
	}

}
