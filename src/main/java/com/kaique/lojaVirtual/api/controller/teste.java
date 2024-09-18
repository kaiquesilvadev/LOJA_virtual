package com.kaique.lojaVirtual.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaique.lojaVirtual.domain.feignclient.BuscaCepFeignClient;

@RestController
@RequestMapping("/teste")
public class teste {

	@Autowired
	private BuscaCepFeignClient buscaCep;

	@GetMapping("/{cep}")
	public ResponseEntity <?> buscaCep(@PathVariable String cep) {

		if (!cep.matches("\\d{5}-\\d{3}")) {
            return ResponseEntity.badRequest().body("Formato de CEP inválido ou incorreto. Corrija e tente novamente.");
		}

		return buscaCep.buscaCep(cep);
	}
}
