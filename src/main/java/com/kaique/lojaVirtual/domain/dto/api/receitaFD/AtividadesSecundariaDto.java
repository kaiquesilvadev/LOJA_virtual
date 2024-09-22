package com.kaique.lojaVirtual.domain.dto.api.receitaFD;

public class AtividadesSecundariaDto {

	private String code;
	private String text;

	public AtividadesSecundariaDto() {
	}

	public AtividadesSecundariaDto(String code, String text) {
		this.code = code;
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
