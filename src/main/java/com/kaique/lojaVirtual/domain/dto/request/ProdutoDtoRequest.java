package com.kaique.lojaVirtual.domain.dto.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.kaique.lojaVirtual.domain.dto.ImagemProdutoDto;
import com.kaique.lojaVirtual.domain.dto.referencias.CategoriaProdutoDtoRef;
import com.kaique.lojaVirtual.domain.dto.referencias.MarcaProdutoDtoRef;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProdutoDtoRequest {

	@NotBlank
	private String tipoUnidade;
	
	@Size(min = 10)
	@NotBlank
	private String nome;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private Double peso;

	@NotNull
	private Double largura;
	
	@NotNull
	private Double autura;
	
	@NotNull
	private Double profundidade;
	
	@NotNull
	private BigDecimal valorVenda;
	
	@NotNull
	private Integer qtdEstoque;
	
	@NotNull
	private Integer qtdeAletaEstoque;
	private Boolean alertaQtdEstoque;

	@NotNull
	@Valid
	private MarcaProdutoDtoRef marcaProduto;

	@NotNull
	@Valid
	private CategoriaProdutoDtoRef categoriaProduto;

	@Size(min = 3 , max = 6 , message = "Você so pode cadastrar no minimo 3 img e no maximo 6.")
	@NotNull
	@Valid
	private List<ImagemProdutoDto> imagemProdutos = new ArrayList<>();

	public ProdutoDtoRequest() {
	}

	public String getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(String tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getAutura() {
		return autura;
	}

	public void setAutura(Double autura) {
		this.autura = autura;
	}

	public Double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(Double profundidade) {
		this.profundidade = profundidade;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Integer getQtdeAletaEstoque() {
		return qtdeAletaEstoque;
	}

	public void setQtdeAletaEstoque(Integer qtdeAletaEstoque) {
		this.qtdeAletaEstoque = qtdeAletaEstoque;
	}

	public Boolean getAlertaQtdEstoque() {
		return alertaQtdEstoque;
	}

	public void setAlertaQtdEstoque(Boolean alertaQtdEstoque) {
		this.alertaQtdEstoque = alertaQtdEstoque;
	}

	public MarcaProdutoDtoRef getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(MarcaProdutoDtoRef marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public CategoriaProdutoDtoRef getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaProdutoDtoRef categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public List<ImagemProdutoDto> getImagemProdutos() {
		return imagemProdutos;
	}

	public void setImagemProdutos(List<ImagemProdutoDto> imagemProdutos) {
		this.imagemProdutos = imagemProdutos;
	}
}
