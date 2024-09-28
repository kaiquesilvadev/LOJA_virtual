package com.kaique.lojaVirtual.domain.dto.response;

import com.kaique.lojaVirtual.domain.dto.referencias.EmpresadtoRef;
import com.kaique.lojaVirtual.domain.dto.referencias.PessoaRefDto;
import com.kaique.lojaVirtual.domain.entity.Endereco;
import com.kaique.lojaVirtual.domain.enuns.TipoEndereco;

public class EnderecoResponseDto {

	private Long id;
	private String ruaLogra;
	private String cep;
	private String numero;
	private String complemento;
	private String bairro;
	private String uf;
	private String cidade;
	private String estado;
	private PessoaRefDto pessoa;
	private TipoEndereco tipoEndereco;
	private EmpresadtoRef empresa;

	public EnderecoResponseDto() {
	}

	public EnderecoResponseDto(Endereco endereco) {
		this.id = endereco.getId();
		this.ruaLogra = endereco.getRuaLogra();
		this.cep = endereco.getCep();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.uf = endereco.getUf();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.pessoa = new PessoaRefDto(endereco.getPessoa());
		this.tipoEndereco = endereco.getTipoEndereco();
		this.empresa = validaSeEnpresaEnull(endereco);
	}
	
	private static EmpresadtoRef validaSeEnpresaEnull(Endereco endereco) {
		if(endereco.getEmpresa() == null) {
			return null;
		}else {
			return new EmpresadtoRef(endereco.getEmpresa());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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

	public PessoaRefDto getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaRefDto pessoa) {
		this.pessoa = pessoa;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public EmpresadtoRef getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresadtoRef empresa) {
		this.empresa = empresa;
	}
}
