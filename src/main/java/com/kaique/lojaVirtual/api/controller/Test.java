package com.kaique.lojaVirtual.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaique.lojaVirtual.domain.dto.api.receitaFD.ReceitaFdApiDto;
import com.kaique.lojaVirtual.domain.services.IntegracaoApiReceitaService;

@RestController
@RequestMapping("/test")
public class Test {

	@Autowired
	private IntegracaoApiReceitaService servives;

	@GetMapping("/buscaCnpj/{cnpj}")
	public ResponseEntity<ReceitaFdApiDto> buscaCnpj(@PathVariable String cnpj) {
		return servives.buscaCnpj(cnpj);
	}
}
