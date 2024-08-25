package com.kaique.lojaVirtual.domain.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_imagem_produto")
public class ImagemProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "TEXT")
	private String imagemOriginal;

	@Column(columnDefinition = "TEXT")
	private String imagemMiniatura;
	private String linkTouTuber;

	@JoinColumn(name = "produto_id")
	@ManyToOne
	private Produto produto;

	public ImagemProduto() {
	}

	public ImagemProduto(Long id, String imagemOriginal, String imagemMiniatura, String linkTouTuber, Produto produto) {
		this.id = id;
		this.imagemOriginal = imagemOriginal;
		this.imagemMiniatura = imagemMiniatura;
		this.linkTouTuber = linkTouTuber;
		this.produto = produto;
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImagemProduto other = (ImagemProduto) obj;
		return Objects.equals(id, other.id);
	}

}
