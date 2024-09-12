package com.kaique.lojaVirtual.domain.enuns;

public enum TipoEndereco {
	
	
	COBRANCA("Cobrança"),
	ENTREGA("Entrega"),
	PARTICULA("Particula"),
	COMERCIAL("Comercial");
	
	private String descricao;
	
	
	private TipoEndereco(String descricao) {
	  this.descricao = descricao;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	}

}