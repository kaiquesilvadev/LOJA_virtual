package com.kaique.lojaVirtual.domain.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.kaique.lojaVirtual.domain.entity.PessoaJuridica;

public class PessoaPjResponse {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cnpj;
	private String inscEstadual;
	private String inscMunicipal;
	private String nomeFantasia;
	private String razaoSocial;
	private List<EnderecoRespCustoDto> enderecos = new ArrayList<>();

	public PessoaPjResponse() {
	}

	public PessoaPjResponse(PessoaJuridica pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.telefone = pessoa.getTelefone();
		this.cnpj = pessoa.getCnpj();
		this.inscEstadual = pessoa.getInscEstadual();
		this.inscMunicipal = pessoa.getInscMunicipal();
		this.nomeFantasia = pessoa.getNomeFantasia();
		this.razaoSocial = pessoa.getRazaoSocial();
		this.enderecos = pessoa.getEnderecos().stream().map(enderecos -> new EnderecoRespCustoDto(enderecos)).toList();
	}

	public List<PessoaPjResponse> converteListEntitry(List<PessoaJuridica> list) {

		List<PessoaPjResponse> novalista = new ArrayList<>();

		for (int x = 0; x < list.size(); x++) {
			PessoaPjResponse dtoResponse = new PessoaPjResponse(list.get(x));
			novalista.add(dtoResponse);
		}

		return novalista;
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getInscMunicipal() {
		return inscMunicipal;
	}

	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public List<EnderecoRespCustoDto> getEnderecos() {
		return enderecos;
	}
}
