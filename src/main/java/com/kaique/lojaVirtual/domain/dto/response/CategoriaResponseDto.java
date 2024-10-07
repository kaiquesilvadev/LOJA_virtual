package com.kaique.lojaVirtual.domain.dto.response;

import com.kaique.lojaVirtual.domain.entity.CategoriaProduto;

public class CategoriaResponseDto {

	private Long id;
	private String nomeDesc;

	public CategoriaResponseDto() {
	}

	public CategoriaResponseDto(Long id, String nomeDesc) {
		this.id = id;
		this.nomeDesc = nomeDesc;
	}
	
	public CategoriaResponseDto(CategoriaProduto categoriaProduto) {
		this.id = categoriaProduto.getId();
		this.nomeDesc = categoriaProduto.getNomeDesc();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDesc() {
		return nomeDesc;
	}

	public void setNomeDesc(String nomeDesc) {
		this.nomeDesc = nomeDesc;
	}

}
