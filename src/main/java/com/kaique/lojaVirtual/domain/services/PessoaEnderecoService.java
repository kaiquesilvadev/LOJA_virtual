package com.kaique.lojaVirtual.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.lojaVirtual.domain.dto.RespostaBuscaCepDto;
import com.kaique.lojaVirtual.domain.dto.request.EnderecoPSFisicaRequestDto;
import com.kaique.lojaVirtual.domain.dto.request.EnderecoRequestDto;
import com.kaique.lojaVirtual.domain.entity.Endereco;
import com.kaique.lojaVirtual.domain.entity.Pessoa;
import com.kaique.lojaVirtual.domain.entity.Usuario;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeNaoEncontradaException;
import com.kaique.lojaVirtual.domain.exceptions.UsuarioNaoAutorisadoException;
import com.kaique.lojaVirtual.domain.repositories.EnderecoRepository;
import com.kaique.lojaVirtual.domain.repositories.PessoaRepository;

@Service
public class PessoaEnderecoService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private ImplementacaoUserDetailsServices detailsServices;

	@Autowired
	private IntegracaoApiCepService apiCepService;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Transactional(propagation = Propagation.SUPPORTS)
	public Pessoa buscaPessoaPorId(Long idPessoa) {
		return pessoaRepository.findById(idPessoa).orElseThrow(() -> new EntidadeNaoEncontradaException(
				"ID de pessoa com código '" + idPessoa + "' não encontrado ."));
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Endereco> ListaEnderecoPs() {

		Usuario usuario = detailsServices.authenticated();
		Pessoa pessoa = pessoaRepository.BuscaPsEndereco(usuario.getPessoa().getId());

		return pessoa.getEnderecos();
	}

	/* TODO : so quem pode atualizar o endereço e o proprio usuario */
	@Transactional
	public Endereco AtualizaEnderecoPSFisica(EnderecoPSFisicaRequestDto dto, Long idEndereco) {
		Usuario usuario = detailsServices.authenticated();
		Endereco endereco = enderecoService.buscaPorId(idEndereco);
		converteEnderecoPsFS(dto, endereco);

		if (!usuario.getPessoa().equals(endereco.getPessoa()))
			throw new UsuarioNaoAutorisadoException("Usuário não autorizado a atualizar esse endereço.");

		return enderecoRepository.save(endereco);
	}

	/*
	 * TODO: regra de negocio , so quem pode atualizar o endereço e o proprio
	 * usuario ou admim da empresa, validar se admim pertence a empresa que ele quer
	 * atualizar o endereco
	 */
	@Transactional
	public Endereco AtualizaEnderecoPSJuridica(EnderecoRequestDto dto, Long idEndereco, Long idPessoa) {

		Usuario usuario = detailsServices.authenticated();
		Endereco endereco = enderecoService.buscaPorId(idEndereco);
		Pessoa pessoa = buscaPessoaPorId(idPessoa);

		validaAtualizacao(idEndereco, idPessoa, usuario, endereco, pessoa);

		return enderecoService.atualiza(dto, endereco, endereco.getPessoa(), endereco.getEmpresa());
	}

	public void validaAtualizacao(Long idEndereco, Long idPessoa, Usuario usuario, Endereco endereco, Pessoa pessoa) {
		if (!endereco.getPessoa().equals(pessoa))
			throw new UsuarioNaoAutorisadoException(
					"Endereço com id " + idEndereco + " não encontrado para a pessoa com id " + idPessoa);

		boolean usuarioProprio = pessoa.getUsuarios().stream().anyMatch(u -> u.getId().equals(usuario.getId()));

		boolean usuarioEFuncionario = pessoa.getUsuarios().stream().anyMatch(u -> u.getEmpresa() != null
				&& usuario.getEmpresa() != null && u.getEmpresa().equals(usuario.getEmpresa()));

		boolean usuarioAdmin = usuario.getAcessos().stream()
				.anyMatch(acesso -> acesso.getAuthority().equals("ROLE_ADMIN"));

		if (!usuarioProprio && !usuarioAdmin) {
			throw new UsuarioNaoAutorisadoException("Usuário não tem permissão para atualizar este endereço.");
		}

		if (usuarioAdmin && usuario.getEmpresa() != null && !usuario.getEmpresa().equals(endereco.getEmpresa())) {
			throw new UsuarioNaoAutorisadoException(
					"Você não tem permissão para atualizar o endereço de uma pessoa fora da sua empresa.");
		}

		if (!usuarioAdmin && !usuarioEFuncionario) {
			throw new UsuarioNaoAutorisadoException(
					"Esse endereço não pertence a um usuário da sua empresa, e você não tem permissão para atualizá-lo.");
		}
	}

	protected void converteEnderecoPsFS(EnderecoPSFisicaRequestDto dto, Endereco endereco) {

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

	}
}
