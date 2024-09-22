package com.kaique.lojaVirtual.domain.dto.response;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.kaique.lojaVirtual.domain.dto.referencias.EmpresadtoRef;
import com.kaique.lojaVirtual.domain.entity.PessoaFisica;
import com.kaique.lojaVirtual.domain.entity.PessoaJuridica;

public class PessoaFisicaDtoResponse {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private Date dataNascimento;
	private EmpresadtoRef empresa;
	List<EnderecoRespCustoDto> enderecos = new ArrayList<>();

	public PessoaFisicaDtoResponse() {
	}

	public PessoaFisicaDtoResponse(PessoaFisica pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.telefone = pessoa.getTelefone();
		this.cpf = pessoa.getCpf();
		this.dataNascimento = pessoa.getDataNascimento();
		this.enderecos = pessoa.getEnderecos().stream().map(enderecos -> new EnderecoRespCustoDto(enderecos)).toList();
	}

	public PessoaFisicaDtoResponse(PessoaFisica pessoa, PessoaJuridica empresa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.telefone = pessoa.getTelefone();
		this.cpf = pessoa.getCpf();
		this.dataNascimento = pessoa.getDataNascimento();
		this.empresa = new EmpresadtoRef(pessoa.getEmpresa());
		this.enderecos = pessoa.getEnderecos().stream().map(enderecos -> new EnderecoRespCustoDto(enderecos)).toList();
	}

	public List<PessoaFisicaDtoResponse> converteListEntitry(List<PessoaFisica> list) {

		List<PessoaFisicaDtoResponse> novalista = new ArrayList<>();

		for (int x = 0; x < list.size(); x++) {
			PessoaFisicaDtoResponse dtoResponse = new PessoaFisicaDtoResponse(list.get(x));
			novalista.add(dtoResponse);
		}

		return novalista;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EmpresadtoRef getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresadtoRef empresa) {
		this.empresa = empresa;
	}

	public List<EnderecoRespCustoDto> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoRespCustoDto> enderecos) {
		this.enderecos = enderecos;
	}

}
