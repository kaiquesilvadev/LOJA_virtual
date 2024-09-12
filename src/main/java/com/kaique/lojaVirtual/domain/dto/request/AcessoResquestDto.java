package com.kaique.lojaVirtual.domain.dto.request;

import jakarta.validation.constraints.NotBlank;

public class AcessoResquestDto {
	
	@NotBlank
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
