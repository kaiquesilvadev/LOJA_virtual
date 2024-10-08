package com.kaique.lojaVirtual.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
@Table(name = "tb_categoria_produto")
public class CategoriaProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeDesc;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private PessoaJuridica empresa;

	@OneToMany(mappedBy = "categoriaProduto" , fetch = FetchType.LAZY)
	private List<Produto> produtos = new ArrayList<>();

	public CategoriaProduto() {
	}

	public CategoriaProduto(Long id, String nomeDesc, PessoaJuridica empresa) {
		this.id = id;
		this.nomeDesc = nomeDesc;
		this.empresa = empresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDesc() {
		return nomeDesc;
	}

	public void setNomeDesc(String nomeDesc) {
		this.nomeDesc = nomeDesc;
	}

	public PessoaJuridica getEmpresa() {
		return empresa;
	}

	public void setEmpresa(PessoaJuridica empresa) {
		this.empresa = empresa;
	}

	public List<Produto> getProdutos() {
		return produtos;
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
		CategoriaProduto other = (CategoriaProduto) obj;
		return Objects.equals(id, other.id);
	}

}
