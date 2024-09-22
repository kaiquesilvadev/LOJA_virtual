package com.kaique.lojaVirtual.domain.dto.api.receitaFD;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ReceitaFdApiDto {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date abertura;
	private String situacao;
	private String tipo;
	private String nome;
	private String porte;
	private String natureza_juridica;
	private String logradouro;
	private String numero;
	private String municipio;
	private String bairro;
	private String uf;
	private String cep;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date data_situacao;
	private String motivo_situacao;
	private String cnpj;
	private String ultima_atualizacao;
	private String status;
	private String fantasia;
	private String complemento;
	private String email;
	private String telefone;
	private String efr;
	private String situacao_especial;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date data_situacao_especial;
	private List<AtividadePrincipalDto> atividade_principal = new ArrayList<>();
	private List<AtividadesSecundariaDto> atividades_secundarias = new ArrayList<>();
	private Double capital_social;
	private List<QsaDto> qsa = new ArrayList<>();
	private Simples simples;
	private Simei simei;

	@JsonIgnore
	private Extra extra; // sem atributos ainda
	private Billing billing;

	public ReceitaFdApiDto() {
	}

	public ReceitaFdApiDto(Date abertura, String situacao, String tipo, String nome, String porte,
			String natureza_juridica, String logradouro, String numero, String municipio, String bairro, String uf,
			String cep, Date data_situacao, String motivo_situacao, String cnpj, String ultima_atualizacao,
			String status, String fantasia, String complemento, String email, String telefone, String efr,
			String situacao_especial, Date data_situacao_especial, Double capital_social, Simples simples, Simei simei,
			Extra extra, Billing billing) {
		this.abertura = abertura;
		this.situacao = situacao;
		this.tipo = tipo;
		this.nome = nome;
		this.porte = porte;
		this.natureza_juridica = natureza_juridica;
		this.logradouro = logradouro;
		this.numero = numero;
		this.municipio = municipio;
		this.bairro = bairro;
		this.uf = uf;
		this.cep = cep;
		this.data_situacao = data_situacao;
		this.motivo_situacao = motivo_situacao;
		this.cnpj = cnpj;
		this.ultima_atualizacao = ultima_atualizacao;
		this.status = status;
		this.fantasia = fantasia;
		this.complemento = complemento;
		this.email = email;
		this.telefone = telefone;
		this.efr = efr;
		this.situacao_especial = situacao_especial;
		this.data_situacao_especial = data_situacao_especial;
		this.capital_social = capital_social;
		this.simples = simples;
		this.simei = simei;
		this.extra = extra;
		this.billing = billing;
	}

	public Date getAbertura() {
		return abertura;
	}

	public void setAbertura(Date abertura) {
		this.abertura = abertura;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getNatureza_juridica() {
		return natureza_juridica;
	}

	public void setNatureza_juridica(String natureza_juridica) {
		this.natureza_juridica = natureza_juridica;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Date getData_situacao() {
		return data_situacao;
	}

	public void setData_situacao(Date data_situacao) {
		this.data_situacao = data_situacao;
	}

	public String getMotivo_situacao() {
		return motivo_situacao;
	}

	public void setMotivo_situacao(String motivo_situacao) {
		this.motivo_situacao = motivo_situacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getUltima_atualizacao() {
		return ultima_atualizacao;
	}

	public void setUltima_atualizacao(String ultima_atualizacao) {
		this.ultima_atualizacao = ultima_atualizacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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

	public String getEfr() {
		return efr;
	}

	public void setEfr(String efr) {
		this.efr = efr;
	}

	public String getSituacao_especial() {
		return situacao_especial;
	}

	public void setSituacao_especial(String situacao_especial) {
		this.situacao_especial = situacao_especial;
	}

	public Date getData_situacao_especial() {
		return data_situacao_especial;
	}

	public void setData_situacao_especial(Date data_situacao_especial) {
		this.data_situacao_especial = data_situacao_especial;
	}

	public List<AtividadePrincipalDto> getAtividade_principal() {
		return atividade_principal;
	}

	public void setAtividade_principal(List<AtividadePrincipalDto> atividade_principal) {
		this.atividade_principal = atividade_principal;
	}

	public List<AtividadesSecundariaDto> getAtividades_secundarias() {
		return atividades_secundarias;
	}

	public void setAtividades_secundarias(List<AtividadesSecundariaDto> atividades_secundarias) {
		this.atividades_secundarias = atividades_secundarias;
	}

	public Double getCapital_social() {
		return capital_social;
	}

	public void setCapital_social(Double capital_social) {
		this.capital_social = capital_social;
	}

	public List<QsaDto> getQsa() {
		return qsa;
	}

	public void setQsa(List<QsaDto> qsa) {
		this.qsa = qsa;
	}

	public Simples getSimples() {
		return simples;
	}

	public void setSimples(Simples simples) {
		this.simples = simples;
	}

	public Simei getSimei() {
		return simei;
	}

	public void setSimei(Simei simei) {
		this.simei = simei;
	}

	public Extra getExtra() {
		return extra;
	}

	public void setExtra(Extra extra) {
		this.extra = extra;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

}
