package com.kaique.lojaVirtual.domain.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kaique.lojaVirtual.domain.entity.Usuario;
import com.kaique.lojaVirtual.domain.repositories.UsuarioRepository;

public class ImplementacaoUserDetailsServices implements UserDetailsService{
	
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	  	Optional<Usuario> usuario = repository.buscaUserPorLogin(username);
	  	
	  	return usuario.orElseThrow(() -> new  UsernameNotFoundException("Usuário não foi encontrado"));
		
	}
}
