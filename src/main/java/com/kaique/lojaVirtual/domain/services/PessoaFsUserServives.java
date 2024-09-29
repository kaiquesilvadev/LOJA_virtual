package com.kaique.lojaVirtual.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.lojaVirtual.domain.dto.request.PessoaFsUserDtoReq;
import com.kaique.lojaVirtual.domain.entity.Endereco;
import com.kaique.lojaVirtual.domain.entity.PessoaFisica;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeExistenteException;
import com.kaique.lojaVirtual.domain.repositories.PessoaFisicaRepository;

@Service
public class PessoaFsUserServives {

	@Autowired
	private PessoaFisicaRepository repository;

	@Autowired
	private UsuarioService UsuarioService;

	@Autowired
	private EnderecoService enderecoService;

	@Transactional(propagation = Propagation.SUPPORTS)
	public PessoaFisica buscaPorCpf(String cpf) {
		return repository.buscaCpf(cpf)
				.orElseThrow(() -> new EntidadeExistenteException("Já existe CNPJ cadastrado com o número: " + cpf));
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<PessoaFisica> buscaPorNome(String nome) {
		return repository.buscaPorNome(nome);
	}

	@Transactional
	public PessoaFisica salvaPessoaUser(PessoaFsUserDtoReq dto) {

		if (repository.existsByEmail(dto.getEmail()) == true)
			throw new EntidadeExistenteException("Email ja cadastrado no sistema.");

		if (repository.buscaCpf(dto.getCpf()).isPresent())
			throw new EntidadeExistenteException("Já existe CPF cadastrado com o número: " + dto.getCpf());

		PessoaFisica pessoa = repository.save(converteDto(dto));
		List<Endereco> enderecos = dto.getEnderecos().stream()
				.map(endereco -> enderecoService.converteEndereco(endereco, pessoa, null , new Endereco())).toList();
		UsuarioService.criaUserPadrao(pessoa, "ROLE_USER" , null);

		pessoa.getEnderecos().addAll(enderecoService.salvaEnderecoList(enderecos));
		return pessoa;
	}

	private PessoaFisica converteDto(PessoaFsUserDtoReq dtoReq) {

		PessoaFisica pessoa = new PessoaFisica();
		pessoa.setNome(dtoReq.getNome());
		pessoa.setEmail(dtoReq.getEmail());
		pessoa.setTelefone(dtoReq.getTelefone());
		pessoa.setCpf(dtoReq.getCpf());
		pessoa.setDataNascimento(dtoReq.getDataNascimento());

		return pessoa;
	}
}
