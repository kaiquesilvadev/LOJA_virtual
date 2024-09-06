package com.kaique.lojaVirtual.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaique.lojaVirtual.domain.entity.Acesso;
import com.kaique.lojaVirtual.domain.entity.Usuario;
import com.kaique.lojaVirtual.domain.repositories.AcessoRepository;
import com.kaique.lojaVirtual.domain.repositories.UsuarioRepository;

@RestController
public class ControleTest {

	@Autowired
	private AcessoRepository acessoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping()
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public Usuario getMethodName(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("id não encontrado"));
	}

	@PostMapping("/acesso")
	public Acesso postMethodAcesso(@RequestBody Acesso entity) {

		return acessoRepository.save(entity);
	}

	@PostMapping("/user")
	public Usuario postMethodUser(@RequestBody Usuario entity) {

		return usuarioRepository.save(entity);

	}
}
