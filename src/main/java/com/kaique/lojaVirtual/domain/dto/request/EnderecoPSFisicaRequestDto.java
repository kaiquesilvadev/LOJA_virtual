package com.kaique.lojaVirtual.domain.dto.request;

import com.kaique.lojaVirtual.domain.enuns.TipoEndereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EnderecoPSFisicaRequestDto {

	private String ruaLogra;
	
	@NotBlank
	private String cep;
	
	@NotBlank
	private String numero;
	private String complemento;
	private String bairro;
	
	@NotNull
	private TipoEndereco tipoEndereco;

	public String getRuaLogra() {
		return ruaLogra;
	}

	public void setRuaLogra(String ruaLogra) {
		this.ruaLogra = ruaLogra;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}
}
