package com.kaique.lojaVirtual.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.lojaVirtual.domain.dto.RespostaBuscaCepDto;
import com.kaique.lojaVirtual.domain.dto.request.EnderecoRequestDto;
import com.kaique.lojaVirtual.domain.entity.Endereco;
import com.kaique.lojaVirtual.domain.entity.Pessoa;
import com.kaique.lojaVirtual.domain.repositories.enderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private enderecoRepository repository;
	
	@Autowired
	private IntegracaoApiCepService apiCepService;

	@Transactional
	public Endereco salvaEndereco(EnderecoRequestDto dto, Pessoa pessoa , Pessoa empresa) {

		Endereco endereco = converteEndereco(dto, pessoa , empresa);
		return repository.save(endereco);
	}
	
	@Transactional
	public List<Endereco> salvaEnderecoList(List<Endereco> enderecos) {

		return repository.saveAll(enderecos);
	}

	protected Endereco converteEndereco(EnderecoRequestDto dto, Pessoa pessoa , Pessoa empresa) {

		
		Endereco endereco = new Endereco();
				
		RespostaBuscaCepDto buscaCep = apiCepService.buscaCep(dto.getCep());

		endereco.setRuaLogra(buscaCep.getLogradouro());
		endereco.setCep(dto.getCep());
		endereco.setNumero(dto.getNumero());
		endereco.setComplemento(dto.getComplemento());
		endereco.setBairro(buscaCep.getBairro());
		endereco.setUf(buscaCep.getUf());
		endereco.setCidade(buscaCep.getLocalidade());
		endereco.setEstado(buscaCep.getEstado());
		endereco.setTipoEndereco(dto.getTipoEndereco());
		endereco.setPessoa(pessoa);
		endereco.setEmpresa(empresa);
		
		return endereco;
	}
}
