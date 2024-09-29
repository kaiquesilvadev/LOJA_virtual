package com.kaique.lojaVirtual.domain.dto.referencias;

import com.kaique.lojaVirtual.domain.entity.PessoaJuridica;

public class EmpresaRefDto {

	private Long id;
	private String nomeFantasia;

	public EmpresaRefDto() {

	}

	public EmpresaRefDto(Long id, String nomeFantasia) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
	}

	public EmpresaRefDto(PessoaJuridica pessoaJuridica) {
		this.id = pessoaJuridica.getId();
		this.nomeFantasia = pessoaJuridica.getNomeFantasia();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
}
