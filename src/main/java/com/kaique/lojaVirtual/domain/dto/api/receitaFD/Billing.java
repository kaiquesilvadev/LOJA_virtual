package com.kaique.lojaVirtual.domain.dto.api.receitaFD;

public class Billing {

	private Boolean free;
	private Boolean database;

	public Billing() {
	}

	public Billing(Boolean free, Boolean database) {
		this.free = free;
		this.database = database;
	}

	public Boolean getFree() {
		return free;
	}

	public void setFree(Boolean free) {
		this.free = free;
	}

	public Boolean getDatabase() {
		return database;
	}

	public void setDatabase(Boolean database) {
		this.database = database;
	}

}
