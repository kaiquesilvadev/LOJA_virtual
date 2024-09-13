package com.kaique.lojaVirtual.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.kaique.lojaVirtual.domain.dto.EmailDTO;
import com.kaique.lojaVirtual.domain.dto.request.UsuarioRequestDto;
import com.kaique.lojaVirtual.domain.entity.Acesso;
import com.kaique.lojaVirtual.domain.entity.Pessoa;
import com.kaique.lojaVirtual.domain.entity.Usuario;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeExistenteException;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeNaoEncontradaException;
import com.kaique.lojaVirtual.domain.repositories.AcessoRepository;
import com.kaique.lojaVirtual.domain.repositories.UsuarioRepository;

@Service
public class usuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private AcessoRepository acessoRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private EmailService emailService;

	@Autowired
	private TemplateEngine templateEngine;

	@Transactional
	public Usuario salvaUser(UsuarioRequestDto dto) {

		if (repository.existsByLogin(dto.getLogin()) == true)
			throw new EntidadeExistenteException("Email ja cadastrado no sistema.");

		return repository.save(converteUser(dto));
	}

	@Transactional
	public Usuario addRoles(Usuario usuario, String role) {

		Optional<Acesso> acesso = acessoRepository.findByDescricao(role);

		if (acesso.isEmpty())
			throw new EntidadeNaoEncontradaException("Role inexistente '" + role + "' tente novamente .");

		usuario.getAcessos().add(acesso.get());

		return usuario;
	}

	@Transactional
	protected Usuario criaUserPadrao(Pessoa Pessoa) {

		Usuario usuario = new Usuario();

		usuario.setLogin(Pessoa.getEmail());
		usuario.setSenha(passwordEncoder.encode(Pessoa.getEmail()));
		usuario.setPessoa(Pessoa);

		addRoles(usuario, "ROLE_ADMIN");

		EmailDTO emailDTO = new EmailDTO();
		emailDTO.setSubject("Bem-vindo à Loja Virtual - Detalhes da sua conta");
		emailDTO.setTo(Pessoa.getEmail());

		
		// Cria o contexto do Thymeleaf
        Context context = new Context();
        context.setVariable("email", Pessoa.getEmail());
        context.setVariable("password", Pessoa.getEmail());

        // Gera o conteúdo HTML a partir do template
        String htmlContent = templateEngine.process("account-details", context);

		emailDTO.setBody(htmlContent);

		emailService.sendEmail(emailDTO);

		return repository.save(usuario);
	}

	protected Usuario converteUser(UsuarioRequestDto dto) {

		Usuario usuario = new Usuario();

		usuario.setLogin(dto.getLogin());
		usuario.setSenha(dto.getSenha());
		usuario.setPessoa(dto.getPessoa());

		return usuario;
	}
}
