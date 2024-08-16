package com.kaique.lojaVirtual.doman.entity;

import java.time.OffsetDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	
	@UpdateTimestamp
	private OffsetDateTime data_atua_senha;	
	
	/*TODO : implementar o restante depois que finalizar classe pessoas */
}
