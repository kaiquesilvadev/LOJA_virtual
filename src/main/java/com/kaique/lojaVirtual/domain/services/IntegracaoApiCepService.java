package com.kaique.lojaVirtual.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kaique.lojaVirtual.domain.dto.RespostaBuscaCepDto;
import com.kaique.lojaVirtual.domain.exceptions.CepIncorretoException;
import com.kaique.lojaVirtual.domain.feignclient.BuscaCepFeignClient;

@Service
public class IntegracaoApiCepService {

	@Autowired
	private BuscaCepFeignClient buscaCep;

	public RespostaBuscaCepDto buscaCep(@PathVariable String cep) {

		ResponseEntity<RespostaBuscaCepDto> response = buscaCep.buscaCep(cep);

		RespostaBuscaCepDto body = response.getBody();
		if (body != null && "true".equals(body.getErro())) {
			throw new CepIncorretoException("CEP não encontrado. por favor digite um cep correto .");
		}

		return body;
	}
}
