package com.kaique.lojaVirtual.domain.dto.response;

import com.kaique.lojaVirtual.domain.entity.MarcaProduto;

public class MarcaResponseDto {

	private Long id;
	private String nomeDesc;

	public MarcaResponseDto() {
	}
	
	public MarcaResponseDto(MarcaProduto marcaProduto) {
		this.id = marcaProduto.getId();
		this.nomeDesc = marcaProduto.getNomeDesc();
	}

	public MarcaResponseDto(Long id, String nomeDesc) {
		this.id = id;
		this.nomeDesc = nomeDesc;
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
