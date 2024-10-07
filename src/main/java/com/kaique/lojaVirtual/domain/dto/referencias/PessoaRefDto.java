package com.kaique.lojaVirtual.domain.dto.referencias;

import com.kaique.lojaVirtual.domain.entity.Pessoa;

import jakarta.validation.constraints.NotNull;

public class PessoaRefDto {

	@NotNull
	private Long id;
	private String nome;

	public PessoaRefDto() {
	}

	public PessoaRefDto(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public PessoaRefDto(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
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
}
