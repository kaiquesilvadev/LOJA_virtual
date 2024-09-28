package com.kaique.lojaVirtual.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kaique.lojaVirtual.domain.dto.request.PessoaFsUserDtoReq;
import com.kaique.lojaVirtual.domain.dto.response.EnderecoRespCustoDto;
import com.kaique.lojaVirtual.domain.dto.response.PessoaFisicaDtoResponse;
import com.kaique.lojaVirtual.domain.entity.Endereco;
import com.kaique.lojaVirtual.domain.services.PessoaEnderecoService;
import com.kaique.lojaVirtual.domain.services.PessoaFsUserServives;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/PessoaFisicas")
public class PessoaFisicaController {

	@Autowired
	private PessoaFsUserServives servives;

	@Autowired
	private PessoaEnderecoService psEnderecoService;

	@GetMapping("/buscaPorNome/{nome}")
	public List<PessoaFisicaDtoResponse> buscaPorNome(@PathVariable String nome) {
		return new PessoaFisicaDtoResponse().converteListEntitry(servives.buscaPorNome(nome));
	}

	@GetMapping("/listaEndereco")
	public List<EnderecoRespCustoDto> buscaPorNome() {

		List<EnderecoRespCustoDto> listCustoDtos = new ArrayList<>();
		List<Endereco> listEndereco = psEnderecoService.ListaEnderecoPs();

		for (int x = 0; x < listEndereco.size(); x++) {
			listCustoDtos.add(new EnderecoRespCustoDto(listEndereco.get(x)));
		}

		return listCustoDtos;
	}

	@GetMapping("/buscaPorCpf/{cpf}")
	public PessoaFisicaDtoResponse buscaPorCnpj(@PathVariable String cpf) {
		return new PessoaFisicaDtoResponse(servives.buscaPorCpf(cpf));
	}

	@PostMapping("/salvaUser")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PessoaFisicaDtoResponse salvaPessoaUser(@Valid @RequestBody PessoaFsUserDtoReq dto) {
		return new PessoaFisicaDtoResponse(servives.salvaPessoaUser(dto));
	}
}
