package com.kaique.lojaVirtual.domain.dto.request;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.kaique.lojaVirtual.domain.entity.Pessoa;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioRequestDto {

	@NotBlank
	private String login;
	
	@NotBlank
	private String senha;
	
	@NotNull
	private Date data_atua_senha;
	private Pessoa pessoa;

	@Valid 
	private List<AcessoResquestDto> acessos = new ArrayList<>();
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getData_atua_senha() {
		return data_atua_senha;
	}
	public void setData_atua_senha(Date data_atua_senha) {
		this.data_atua_senha = data_atua_senha;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public List<AcessoResquestDto> getAcessos() {
		return acessos;
	}
	public void setAcessos(List<AcessoResquestDto> acessos) {
		this.acessos = acessos;
	}
}
