package com.kaique.lojaVirtual.domain.dto.request;

import jakarta.validation.constraints.NotNull;

public class CategoriaRequestDto {

	@NotNull
	private String nomeDesc;


	public CategoriaRequestDto() {
	}

	public CategoriaRequestDto(String nomeDesc) {
		this.nomeDesc = nomeDesc;
	
	}

	public String getNomeDesc() {
		return nomeDesc;
	}

	public void setNomeDesc(String nomeDesc) {
		this.nomeDesc = nomeDesc;
	}
}
