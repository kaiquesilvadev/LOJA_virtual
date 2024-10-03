package com.kaique.lojaVirtual.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.lojaVirtual.domain.dto.request.CategoriaRequestDto;
import com.kaique.lojaVirtual.domain.entity.CategoriaProduto;
import com.kaique.lojaVirtual.domain.entity.Usuario;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeEmUsoException;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeExistenteException;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeNaoEncontradaException;
import com.kaique.lojaVirtual.domain.exceptions.UsuarioNaoAutorisadoException;
import com.kaique.lojaVirtual.domain.repositories.CategoriaProdutoRepository;

@Service
public class CategoriaProdutoService {

	@Autowired
	private CategoriaProdutoRepository repository;

	@Autowired
	private ImplementacaoUserDetailsServices detailsServices;

	@Transactional(propagation = Propagation.SUPPORTS)
	public CategoriaProduto buscaPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("ID de código '" + id + "' não encontrado ."));
	}

	/*TODO: uma empresa so pode ter a categoria da msm descrição salsa uma vez , apenas empresas pode add uma categoria*/
	@Transactional
	public CategoriaProduto Salva(CategoriaRequestDto dto) {

		Usuario usuario = validaSalvarEAtualizar(dto);
		CategoriaProduto novaCategoria = new CategoriaProduto();
		novaCategoria.setEmpresa(usuario.getEmpresa());
		return repository.save(convertdto(dto, novaCategoria));
	}

	
	/*TODO : apenas a propria empresa pode atualizar a descrição da categoria, categoria não pode conter a msm descrição*/
	@Transactional
	public CategoriaProduto atualizar(CategoriaRequestDto dto, Long id) {

		CategoriaProduto categoriaProduto = buscaPorId(id);

		Usuario usuario = validaSalvarEAtualizar(dto);
		
		if(!usuario.getEmpresa().equals(categoriaProduto.getEmpresa()))
			throw new UsuarioNaoAutorisadoException("Você só pode atualizar uma Categoria da sua propria empresa");

		return repository.save(convertdto(dto, categoriaProduto));
	}

	/*TODO : apenas a propria empresa pode apagar sua categoria */
	@Transactional
	public void deletar(Long id) {
		
		Usuario usuario = detailsServices.authenticated();
		CategoriaProduto categoriaProduto = buscaPorId(id);
		
		if (usuario.getEmpresa() == null)
			throw new UsuarioNaoAutorisadoException(
					"Apenas empresas cadastradas no sistema podem apagar uma categoria");
		
		if(!usuario.getEmpresa().equals(categoriaProduto.getEmpresa()))
			throw new UsuarioNaoAutorisadoException("Você só pode apagar uma Categoria da sua propria empresa");
		
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(id);
		}

	}

	private Usuario validaSalvarEAtualizar(CategoriaRequestDto dto) {
		Usuario usuario = detailsServices.authenticated();

		if (usuario.getEmpresa() == null)
			throw new UsuarioNaoAutorisadoException(
					"Apenas empresas cadastradas no sistema podem adicionar ou atualizar uma categoria");

		if (repository.buscaDescricaoPorEmpresa(dto.getNomeDesc(), usuario.getEmpresa()).isPresent())
			throw new EntidadeExistenteException("Já existe uma Categoria com esse nome '" + dto.getNomeDesc() + "'");
		return usuario;
	}

	private CategoriaProduto convertdto(CategoriaRequestDto Dto, CategoriaProduto categoriaProduto) {

		categoriaProduto.setNomeDesc(Dto.getNomeDesc());

		return categoriaProduto;
	}
}
