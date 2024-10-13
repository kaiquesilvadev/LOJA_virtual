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
	private Boolean ativo = Boolean.TRUE;
	private Double peso;
	private Double largura;
	private Double autura;
	private Double profundidade;
	private BigDecimal valorVenda;
	private Integer qtdEstoque = 0;
	private Integer qtdeAletaEstoque = 0;
	private Boolean alertaQtdEstoque = Boolean.FALSE;
	private Integer qtdeClique = 0;

	@ManyToOne
	@JoinColumn(name = "marca_produto_id")
	private MarcaProduto marcaProduto;

	@ManyToOne
	@JoinColumn(name = "categoria_produto_id")
	private CategoriaProduto categoriaProduto;

	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ImagemProduto> imagemProdutos = new ArrayList<>();

	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private List<AvaliacaoProduto> avaliacoes = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private PessoaJuridica empresa;

	public Produto() {
	}

	public Produto(Long id, String tipoUnidade, String nome, String descricao, Boolean ativo, Double peso,
			Double largura, Double autura, Double profundidade, BigDecimal valorVenda, Integer qtdEstoque,
			Integer qtdeAletaEstoque, Boolean alertaQtdEstoque, Integer qtdeClique, MarcaProduto marcaProduto,
			CategoriaProduto categoriaProduto, PessoaJuridica empresa) {
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
		this.empresa = empresa;
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

	public PessoaJuridica getEmpresa() {
		return empresa;
	}

	public void setEmpresa(PessoaJuridica empresa) {
		this.empresa = empresa;
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
