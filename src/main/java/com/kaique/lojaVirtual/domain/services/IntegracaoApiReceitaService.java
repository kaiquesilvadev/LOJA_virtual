package com.kaique.lojaVirtual.domain.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kaique.lojaVirtual.domain.dto.api.receitaFD.ReceitaFdApiDto;

@Service
public class IntegracaoApiReceitaService {

	private static final String urlReceita = "https://www.receitaws.com.br/v1/cnpj/";

	public ResponseEntity<ReceitaFdApiDto> buscaCnpj(String cnpj) {
		return new RestTemplate().getForEntity(urlReceita + cnpj, ReceitaFdApiDto.class);
	}
}
