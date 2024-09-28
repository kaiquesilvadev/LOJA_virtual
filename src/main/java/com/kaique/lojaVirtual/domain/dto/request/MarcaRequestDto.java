package com.kaique.lojaVirtual.domain.dto.request;

import jakarta.validation.constraints.NotBlank;

public class MarcaRequestDto {

	@NotBlank
	private String nomeDesc;

	public MarcaRequestDto() {
	}

	public MarcaRequestDto(@NotBlank String nomeDesc) {
		this.nomeDesc = nomeDesc;
	}

	public String getNomeDesc() {
		return nomeDesc;
	}

	public void setNomeDesc(String nomeDesc) {
		this.nomeDesc = nomeDesc;
	}
}
