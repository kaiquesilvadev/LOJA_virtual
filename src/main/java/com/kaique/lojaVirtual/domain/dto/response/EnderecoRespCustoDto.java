package com.kaique.lojaVirtual.domain.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.kaique.lojaVirtual.domain.entity.Endereco;
import com.kaique.lojaVirtual.domain.enuns.TipoEndereco;

public class EnderecoRespCustoDto {

	
	private Long id;
	private String cep;
	private String numero;	
	private String cidade;
	private String estado;
	private TipoEndereco tipoEndereco;
	
	public EnderecoRespCustoDto(Endereco endereco) {
		this.id = endereco.getId();
		this.cep = endereco.getCep();
		this.numero = endereco.getNumero();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.tipoEndereco = endereco.getTipoEndereco();
	}
	
	public static List<EnderecoRespCustoDto> listaEnderecoProprios(List<Endereco> listEndereco) {

		List<EnderecoRespCustoDto> listCustoDtos = new ArrayList<>();

		for (int x = 0; x < listEndereco.size(); x++) {
			listCustoDtos.add(new EnderecoRespCustoDto(listEndereco.get(x)));
		}

		return listCustoDtos;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}
	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}
}
