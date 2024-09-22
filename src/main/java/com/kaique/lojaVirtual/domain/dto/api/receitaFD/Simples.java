package com.kaique.lojaVirtual.domain.dto.api.receitaFD;

import java.time.OffsetDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Simples {

	private Boolean optante;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date data_opcao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date data_exclusao;
	private OffsetDateTime ultima_atualizacao;

	public Simples() {
	}

	public Simples(Boolean optante, Date data_opcao, Date data_exclusao, OffsetDateTime ultima_atualizacao) {
		this.optante = optante;
		this.data_opcao = data_opcao;
		this.data_exclusao = data_exclusao;
		this.ultima_atualizacao = ultima_atualizacao;
	}

	public Boolean getOptante() {
		return optante;
	}

	public void setOptante(Boolean optante) {
		this.optante = optante;
	}

	public Date getData_opcao() {
		return data_opcao;
	}

	public void setData_opcao(Date data_opcao) {
		this.data_opcao = data_opcao;
	}

	public Date getData_exclusao() {
		return data_exclusao;
	}

	public void setData_exclusao(Date data_exclusao) {
		this.data_exclusao = data_exclusao;
	}

	public OffsetDateTime getUltima_atualizacao() {
		return ultima_atualizacao;
	}

	public void setUltima_atualizacao(OffsetDateTime ultima_atualizacao) {
		this.ultima_atualizacao = ultima_atualizacao;
	}

}