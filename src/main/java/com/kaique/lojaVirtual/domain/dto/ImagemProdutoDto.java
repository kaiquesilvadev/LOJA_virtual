package com.kaique.lojaVirtual.domain.dto;

import jakarta.validation.constraints.NotBlank;

public class ImagemProdutoDto {

	@NotBlank
	private String imagemOriginal;

	@NotBlank
	private String imagemMiniatura;

	@NotBlank
	private String linkTouTuber;

	public String getImagemOriginal() {
		return imagemOriginal;
	}

	public void setImagemOriginal(String imagemOriginal) {
		this.imagemOriginal = imagemOriginal;
	}

	public String getImagemMiniatura() {
		return imagemMiniatura;
	}

	public void setImagemMiniatura(String imagemMiniatura) {
		this.imagemMiniatura = imagemMiniatura;
	}

	public String getLinkTouTuber() {
		return linkTouTuber;
	}

	public void setLinkTouTuber(String linkTouTuber) {
		this.linkTouTuber = linkTouTuber;
	}

}
