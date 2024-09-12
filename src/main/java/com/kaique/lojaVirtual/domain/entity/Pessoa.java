package com.kaique.lojaVirtual.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;

@Entity
/**
 * Configura a herança para que cada classe concreta herde da classe base tenha
 * sua própria tabela no banco de dados. Isso significa que cada subclasse terá
 * uma tabela separada, com todas as colunas da classe base e suas próprias
 * colunas. A tabela da classe base não será criada.
 */
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
	//@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;

	@OneToMany(mappedBy = "pessoa")
	private List<Usuario> usuarios = new ArrayList<>();
	
	@OneToMany(mappedBy = "pessoa" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Endereco> enderecos = new ArrayList<>();

	public Pessoa() {
	}

	public Pessoa(Long id, String nome, String email, String telefone) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
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
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}

}
