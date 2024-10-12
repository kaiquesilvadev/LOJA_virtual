package com.kaique.lojaVirtual.domain.dto.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.kaique.lojaVirtual.domain.dto.referencias.CategoriaProdutoDtoRef;
import com.kaique.lojaVirtual.domain.dto.referencias.MarcaProdutoDtoRef;
import com.kaique.lojaVirtual.domain.entity.Produto;

public class ProdutoResponseDto {

	private Long id;
	private String tipoUnidade;
	private String nome;
	private String descricao;
	private Boolean ativo;
	private Double peso;
	private Double largura;
	private Double autura;
	private Double profundidade;
	private BigDecimal valorVenda;
	private Integer qtdEstoque;
	private Integer qtdeAletaEstoque;
	private Boolean alertaQtdEstoque;
	private Integer qtdeClique;
	private MarcaProdutoDtoRef marcaProduto;
	private CategoriaProdutoDtoRef categoriaProduto;

	private List<ImagemProdutoRespDto> imagemProdutos = new ArrayList<>();

	public ProdutoResponseDto() {
	}

	public ProdutoResponseDto(Produto produto) {
		this.id = produto.getId();
		this.tipoUnidade = produto.getTipoUnidade();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.ativo = produto.getAtivo();
		this.peso = produto.getPeso();
		this.largura = produto.getLargura();
		this.autura = produto.getAutura();
		this.profundidade = produto.getProfundidade();
		this.valorVenda = produto.getValorVenda();
		this.qtdEstoque = produto.getQtdEstoque();
		this.qtdeAletaEstoque = produto.getQtdeAletaEstoque();
		this.alertaQtdEstoque = produto.getAlertaQtdEstoque();
		this.qtdeClique = produto.getQtdeClique();
		this.marcaProduto = new MarcaProdutoDtoRef(produto.getMarcaProduto().getId());
		this.categoriaProduto = new CategoriaProdutoDtoRef(produto.getCategoriaProduto().getId());

		this.imagemProdutos = produto.getImagemProdutos().stream().map(Img -> new ImagemProdutoRespDto(Img)).toList();
	}

	public ProdutoResponseDto(Long id, String tipoUnidade, String nome, String descricao, Boolean ativo, Double peso,
			Double largura, Double autura, Double profundidade, BigDecimal valorVenda, Integer qtdEstoque,
			Integer qtdeAletaEstoque, Boolean alertaQtdEstoque, Integer qtdeClique, MarcaProdutoDtoRef marcaProduto,
			CategoriaProdutoDtoRef categoriaProduto) {
		this.id = id;
		this.tipoUnidade = tipoUnidade;
		this.nome = nome;
		this.descricao = descricao;
		this.ativo = ativo;
		this.peso = peso;
		this.largura = largura;
		this.autura = autura;
		this.profundidade = profundidade;
		this.valorVenda = valorVenda;
		this.qtdEstoque = qtdEstoque;
		this.qtdeAletaEstoque = qtdeAletaEstoque;
		this.alertaQtdEstoque = alertaQtdEstoque;
		this.qtdeClique = qtdeClique;
		this.marcaProduto = marcaProduto;
		this.categoriaProduto = categoriaProduto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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

	public Integer getQtdeClique() {
		return qtdeClique;
	}

	public void setQtdeClique(Integer qtdeClique) {
		this.qtdeClique = qtdeClique;
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

	public List<ImagemProdutoRespDto> getImagemProdutos() {
		return imagemProdutos;
	}

	public void setImagemProdutos(List<ImagemProdutoRespDto> imagemProdutos) {
		this.imagemProdutos = imagemProdutos;
	}

}
