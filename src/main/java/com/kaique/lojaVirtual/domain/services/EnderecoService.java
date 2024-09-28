package com.kaique.lojaVirtual.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.lojaVirtual.domain.dto.RespostaBuscaCepDto;
import com.kaique.lojaVirtual.domain.dto.request.EnderecoRequestDto;
import com.kaique.lojaVirtual.domain.entity.Endereco;
import com.kaique.lojaVirtual.domain.entity.Pessoa;
import com.kaique.lojaVirtual.domain.entity.PessoaJuridica;
import com.kaique.lojaVirtual.domain.entity.Usuario;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeNaoEncontradaException;
import com.kaique.lojaVirtual.domain.exceptions.UsuarioNaoAutorisadoException;
import com.kaique.lojaVirtual.domain.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	@Autowired
	private IntegracaoApiCepService apiCepService;

	@Autowired
	private ImplementacaoUserDetailsServices detailsServices;

	@Transactional(propagation = Propagation.SUPPORTS)
	public Endereco buscaPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("ID de código '" + id + "' não encontrado ."));
	}

	@Transactional
	public Endereco salvaEndereco(EnderecoRequestDto dto, Pessoa pessoa, PessoaJuridica empresa) {

		Endereco endereco = converteEndereco(dto, pessoa, empresa , new Endereco());
		return repository.save(endereco);
	}
	
	@Transactional
	public Endereco atualiza(EnderecoRequestDto dto, Endereco endereco, Pessoa pessoa, PessoaJuridica empresa) {

		endereco = converteEndereco(dto, pessoa, empresa , endereco);
		return repository.save(endereco);
	}
	
	@Transactional
	public List<Endereco> salvaEnderecoList(List<Endereco> enderecos) {

		return repository.saveAll(enderecos);
	}

	@Transactional
	public void deletar(Long id) {

		Usuario usuario = detailsServices.authenticated();
		Endereco endereco = buscaPorId(id);

		// TODO: depois de fazer o Crude de acesso valida se usuario é admim pq ai ele tbm pode deletar o email
		if (!usuario.getPessoa().equals(endereco.getPessoa()))
			throw new UsuarioNaoAutorisadoException("Usuário não autorizado a apagar esse endereço.");

		repository.deleteById(id);

	}

	protected Endereco converteEndereco(EnderecoRequestDto dto, Pessoa pessoa, PessoaJuridica empresa , Endereco endereco) {

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
