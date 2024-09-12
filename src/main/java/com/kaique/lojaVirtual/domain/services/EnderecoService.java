package com.kaique.lojaVirtual.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.lojaVirtual.domain.dto.request.EnderecoRequestDto;
import com.kaique.lojaVirtual.domain.entity.Endereco;
import com.kaique.lojaVirtual.domain.entity.Pessoa;
import com.kaique.lojaVirtual.domain.repositories.enderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private enderecoRepository repository;

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

		endereco.setRuaLogra(dto.getRuaLogra());
		endereco.setCep(dto.getCep());
		endereco.setNumero(dto.getNumero());
		endereco.setComplemento(dto.getComplemento());
		endereco.setBairro(dto.getBairro());
		endereco.setUf(dto.getUf());
		endereco.setCidade(dto.getCidade());
		endereco.setEstado(dto.getEstado());
		endereco.setTipoEndereco(dto.getTipoEndereco());
		endereco.setPessoa(pessoa);
		endereco.setEmpresa(empresa);
		
		return endereco;
	}
}
