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
import com.kaique.lojaVirtual.domain.entity.Pessoa;
import com.kaique.lojaVirtual.domain.entity.PessoaJuridica;
import com.kaique.lojaVirtual.domain.entity.Usuario;
import com.kaique.lojaVirtual.domain.enuns.StatusContaPagar;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeEmUsoException;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeNaoEncontradaException;
import com.kaique.lojaVirtual.domain.exceptions.UsuarioNaoAutorisadoException;
import com.kaique.lojaVirtual.domain.repositories.ContaPagarRepository;

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
		
		if (usuario.getEmpresa() == null)
			throw new UsuarioNaoAutorisadoException("Apenas empresas cadastradas no sistema podem adicionar uma conta a pagar");

		Endereco endereco = enderecoService.converteEndereco(dto.getEndereco(), usuario.getPessoa(), usuario.getEmpresa(), new Endereco());
		/*TODO : add depois notaFiscalCompra */
		ContaPagar contaPagar = converteDto(dto, new ContaPagar(), usuario.getEmpresa(), endereco , usuario.getPessoa());

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
	
	private ContaPagar converteDto(ContaPagarRequestDto dto, ContaPagar ContaPagar, PessoaJuridica empresa, Endereco endereco , Pessoa pessoa) {

		ContaPagar.setDescricao(dto.getDescricao());
		ContaPagar.setValortotal(dto.getValortotal());
		ContaPagar.setValorDesconto(dto.getValorDesconto());
		ContaPagar.setDtVencimento(dto.getDtVencimento());
		ContaPagar.setDtPagamento(dto.getDtPagamento());
		ContaPagar.setStatus(StatusContaPagar.ABERTA);
		ContaPagar.setEndereco(endereco);
		ContaPagar.setEmpresa(empresa);
		
		NotaFiscalCompra notaFiscalCompra = new NotaFiscalCompra();
		notaFiscalCompra.setNumeroNota(dto.getNotaFiscalCompra().getNumeroNota());
		notaFiscalCompra.setSerieNota(dto.getNotaFiscalCompra().getSerieNota());
		notaFiscalCompra.setDescricaoOds(dto.getNotaFiscalCompra().getDescricaoOds());
		notaFiscalCompra.setValorTotal(dto.getNotaFiscalCompra().getValorTotal());
		notaFiscalCompra.setValorDesconto(dto.getNotaFiscalCompra().getValorDesconto());
		notaFiscalCompra.setValorIcms(dto.getNotaFiscalCompra().getValorIcms());
		notaFiscalCompra.setPessoa(pessoa);
		notaFiscalCompra.setEmpresa(empresa);
		
		ContaPagar.setNotaFiscalCompra(notaFiscalCompra);

		PessoaJuridica pessoaFornecedo = new PessoaJuridica();
		pessoaFornecedo.setNome(dto.getPessoaFornecedo().getNome());
		pessoaFornecedo.setEmail(dto.getPessoaFornecedo().getEmail());
		pessoaFornecedo.setTelefone(dto.getPessoaFornecedo().getTelefone());
		pessoaFornecedo.setCnpj(dto.getPessoaFornecedo().getCnpj());
		pessoaFornecedo.setNomeFantasia(dto.getPessoaFornecedo().getNomeFantasia());

		ContaPagar.setPessoaFornecedo(pessoaFornecedo);

		return ContaPagar;
	}
	
}
