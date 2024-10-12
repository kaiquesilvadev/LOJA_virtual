package com.kaique.lojaVirtual.domain.dto.response;

import com.kaique.lojaVirtual.domain.entity.ImagemProduto;

public class ImagemProdutoRespDto {

	private Long id;
	private String imagemOriginal;
	private String imagemMiniatura;
	private String linkTouTuber;

	public ImagemProdutoRespDto() {
	}

	public ImagemProdutoRespDto(ImagemProduto imagemProduto) {
		this.id = imagemProduto.getId();
		this.imagemOriginal = imagemProduto.getImagemOriginal();
		this.imagemMiniatura = imagemProduto.getImagemMiniatura();
		this.linkTouTuber = imagemProduto.getLinkTouTuber();
	}

	public ImagemProdutoRespDto(Long id, String imagemOriginal, String imagemMiniatura, String linkTouTuber) {
		this.id = id;
		this.imagemOriginal = imagemOriginal;
		this.imagemMiniatura = imagemMiniatura;
		this.linkTouTuber = linkTouTuber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
