package com.kaique.lojaVirtual.domain.dto.api.receitaFD;

public class QsaDto {

	private String nome;
	private String qual;

	public QsaDto() {
	}

	public QsaDto(String nome, String qual) {
		this.nome = nome;
		this.qual = qual;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQual() {
		return qual;
	}

	public void setQual(String qual) {
		this.qual = qual;
	}

}
