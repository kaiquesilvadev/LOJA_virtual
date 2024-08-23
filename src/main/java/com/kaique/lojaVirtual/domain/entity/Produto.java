package com.kaique.lojaVirtual.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tipoUnidade;
	private String nome;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "nota_item_produto")
	private NotaItemProduto notaItemProduto;
	private Double peso;
	private Double largura;
	private Double autura;
	private Double profundidade;
	private BigDecimal valorVenda;
	private Integer qtdEstoque;
	private Integer qtdeAletaEstoque;
	private String linkTouTuber;
	private Boolean alertaQtdEstoque;
	private Integer qtdCliente;

	@ManyToOne
	@JoinColumn(name = "marca_produto_id")
	private MarcaProduto marcaProduto;

	@ManyToOne
	@JoinColumn(name = "categoria_produto_id")
	private CategoriaProduto categoriaProduto;

	@OneToMany(mappedBy = "produto", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<ImagemProduto> imagemProdutos = new ArrayList<>();

	@OneToMany(mappedBy = "produto", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<AvaliacaoProduto> avaliacoes = new ArrayList<>();

	public Produto() {
	}

	public Produto(Long id, String tipoUnidade, String nome, String descricao, NotaItemProduto notaItemProduto,
			Double peso, Double largura, Double autura, Double profundidade, BigDecimal valorVenda, Integer qtdEstoque,
			Integer qtdeAletaEstoque, String linkTouTuber, Boolean alertaQtdEstoque, Integer qtdCliente,
			MarcaProduto marcaProduto, CategoriaProduto categoriaProduto) {
		this.id = id;
		this.tipoUnidade = tipoUnidade;
		this.nome = nome;
		this.descricao = descricao;
		this.notaItemProduto = notaItemProduto;
		this.peso = peso;
		this.largura = largura;
		this.autura = autura;
		this.profundidade = profundidade;
		this.valorVenda = valorVenda;
		this.qtdEstoque = qtdEstoque;
		this.qtdeAletaEstoque = qtdeAletaEstoque;
		this.linkTouTuber = linkTouTuber;
		this.alertaQtdEstoque = alertaQtdEstoque;
		this.qtdCliente = qtdCliente;
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

	public NotaItemProduto getNotaItemProduto() {
		return notaItemProduto;
	}

	public void setNotaItemProduto(NotaItemProduto notaItemProduto) {
		this.notaItemProduto = notaItemProduto;
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

	public String getLinkTouTuber() {
		return linkTouTuber;
	}

	public void setLinkTouTuber(String linkTouTuber) {
		this.linkTouTuber = linkTouTuber;
	}

	public Boolean getAlertaQtdEstoque() {
		return alertaQtdEstoque;
	}

	public void setAlertaQtdEstoque(Boolean alertaQtdEstoque) {
		this.alertaQtdEstoque = alertaQtdEstoque;
	}

	public Integer getQtdCliente() {
		return qtdCliente;
	}

	public void setQtdCliente(Integer qtdCliente) {
		this.qtdCliente = qtdCliente;
	}

	public MarcaProduto getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(MarcaProduto marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public List<ImagemProduto> getImagemProdutos() {
		return imagemProdutos;
	}

	public List<AvaliacaoProduto> getAvaliacoes() {
		return avaliacoes;
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

}
