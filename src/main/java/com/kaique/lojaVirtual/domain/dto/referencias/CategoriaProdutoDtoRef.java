package com.kaique.lojaVirtual.domain.dto.referencias;

import jakarta.validation.constraints.NotNull;

public class CategoriaProdutoDtoRef {

	@NotNull
	private Long id;
	
	public CategoriaProdutoDtoRef() {
	}

	public CategoriaProdutoDtoRef(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
