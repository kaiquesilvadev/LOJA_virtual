package com.kaique.lojaVirtual.domain.dto.referencias;

import jakarta.validation.constraints.NotNull;

public class ProdutoDtoRef {

	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
