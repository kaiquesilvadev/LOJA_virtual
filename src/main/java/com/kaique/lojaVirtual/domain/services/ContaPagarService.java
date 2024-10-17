package com.kaique.lojaVirtual.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.lojaVirtual.domain.dto.request.ContaPagarRequestDto;
import com.kaique.lojaVirtual.domain.entity.ContaPagar;
import com.kaique.lojaVirtual.domain.entity.Endereco;
import com.kaique.lojaVirtual.domain.entity.NotaFiscalCompra;
import com.kaique.lojaVirtual.domain.entity.PessoaJuridica;
import com.kaique.lojaVirtual.domain.entity.Usuario;
import com.kaique.lojaVirtual.domain.enuns.StatusContaPagar;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeEmUsoException;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeNaoEncontradaException;
import com.kaique.lojaVirtual.domain.exceptions.UsuarioNaoAutorisadoException;
import com.kaique.lojaVirtual.domain.repositories.ContaPagarRepository;
import com.kaique.lojaVirtual.domain.repositories.UsuarioRepository;

@Service
public class ContaPagarService {

	@Autowired
	private ContaPagarRepository repository;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private ImplementacaoUserDetailsServices detailsServices;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public ContaPagar buscaPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("ID de conta a pagar código '" + id + "' não encontrado ."));
 
	}

	/* TODO : não deve salvar uma conta com o mesmo nome */
	@Transactional
	public ContaPagar salva(ContaPagarRequestDto dto) {

		Usuario usuario = detailsServices.authenticated();
		Endereco endereco = enderecoService.converteEndereco(dto.getEndereco(), usuario.getPessoa(), usuario.getEmpresa(), new Endereco());

		if (usuario.getEmpresa() == null)
			throw new UsuarioNaoAutorisadoException("Apenas empresas cadastradas no sistema podem adicionar uma conta a pagar");

		/*TODO : add depois notaFiscalCompra */
		ContaPagar contaPagar = converteDto(dto, new ContaPagar(), usuario.getEmpresa(), null, endereco);

		return repository.save(contaPagar);
	}
	
	
	@Transactional
	public void deletar(Long id) {
		Usuario usuario = detailsServices.authenticated();
		ContaPagar produto = buscaPorId(id);

		Optional<Usuario> resultConsultaAcesso = usuarioService.buscaAcessoUsuario(usuario.getId(), "ROLE_ADMIM");

		if (usuario.getEmpresa() == null)
			throw new UsuarioNaoAutorisadoException("Apenas empresas cadastradas no sistema podem apagar uma conta a pagar");

		if (!usuario.getEmpresa().equals(produto.getEmpresa()) && resultConsultaAcesso.isEmpty())
			throw new UsuarioNaoAutorisadoException("Você só pode apagar uma conta a pagar se for admim da empresa");

		try {
			buscaPorId(id);
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(id);
		}
	}
	
	private ContaPagar converteDto(ContaPagarRequestDto dto, ContaPagar ContaPagar, PessoaJuridica empresa,
			NotaFiscalCompra notaFiscalCompra, Endereco endereco) {

		ContaPagar.setDescricao(dto.getDescricao());
		ContaPagar.setValortotal(dto.getValortotal());
		ContaPagar.setValorDesconto(dto.getValorDesconto());
		ContaPagar.setDtVencimento(dto.getDtVencimento());
		ContaPagar.setDtPagamento(dto.getDtPagamento());
		ContaPagar.setStatus(StatusContaPagar.ABERTA);
		/* TODO : falta ainda add o notaFiscalCompra */
		ContaPagar.setEndereco(endereco);

		PessoaJuridica pessoaFornecedo = new PessoaJuridica();
		pessoaFornecedo.setNome(dto.getPessoaFornecedoDto().getNome());
		pessoaFornecedo.setEmail(dto.getPessoaFornecedoDto().getEmail());
		pessoaFornecedo.setTelefone(dto.getPessoaFornecedoDto().getTelefone());
		pessoaFornecedo.setCnpj(dto.getPessoaFornecedoDto().getCnpj());
		pessoaFornecedo.setNomeFantasia(dto.getPessoaFornecedoDto().getNomeFantasia());

		ContaPagar.setPessoaFornecedo(pessoaFornecedo);

		return ContaPagar;
	}
}
