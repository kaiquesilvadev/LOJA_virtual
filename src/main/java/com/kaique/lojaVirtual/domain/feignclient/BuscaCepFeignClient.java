package com.kaique.lojaVirtual.domain.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kaique.lojaVirtual.domain.dto.RespostaBuscaCepDto;

@Component
@FeignClient(name = "viacep-client", url = "https://viacep.com.br/ws")
public interface BuscaCepFeignClient {
    @GetMapping("/{cep}/json/")
    ResponseEntity<RespostaBuscaCepDto> buscaCep(@PathVariable("cep") String cep);
}
