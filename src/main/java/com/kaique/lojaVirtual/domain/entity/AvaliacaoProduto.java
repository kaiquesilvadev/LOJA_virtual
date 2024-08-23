package com.kaique.lojaVirtual.domain.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_avaliacao_produto")
public class AvaliacaoProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer nota;
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private PessoaFisica pessoa;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private PessoaJuridica empresa;

	public AvaliacaoProduto() {
	}

	public AvaliacaoProduto(Long id, Integer nota, String descricao, PessoaFisica pessoa, Produto produto,
			PessoaJuridica empresa) {
		this.id = id;
		this.nota = nota;
		this.descricao = descricao;
		this.pessoa = pessoa;
		this.produto = produto;
		this.empresa = empresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PessoaFisica getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaFisica pessoa) {
		this.pessoa = pessoa;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public PessoaJuridica getEmpresa() {
		return empresa;
	}

	public void setEmpresa(PessoaJuridica empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, empresa, id, nota, pessoa, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoProduto other = (AvaliacaoProduto) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(empresa, other.empresa)
				&& Objects.equals(id, other.id) && Objects.equals(nota, other.nota)
				&& Objects.equals(pessoa, other.pessoa) && Objects.equals(produto, other.produto);
	}

}
