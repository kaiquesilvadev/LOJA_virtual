package com.kaique.lojaVirtual.domain.dto;

import com.kaique.lojaVirtual.domain.dto.referencias.PessoaRefDto;
import com.kaique.lojaVirtual.domain.dto.referencias.ProdutoDtoRef;
import com.kaique.lojaVirtual.domain.entity.PessoaJuridica;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ImagemProdutoDto {

	@NotBlank
	private String imagemOriginal;

	@NotBlank
	private String imagemMiniatura;

	@NotBlank
	private String linkTouTuber;

	@NotNull
	@Valid
	private ProdutoDtoRef produto;
	
	@NotNull
	@Valid
	private PessoaRefDto empresa;

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

	public ProdutoDtoRef getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDtoRef produto) {
		this.produto = produto;
	}

}
