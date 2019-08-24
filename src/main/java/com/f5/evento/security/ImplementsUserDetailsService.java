package com.f5.evento.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.f5.evento.model.Usuarios;
import com.f5.evento.repository.UsuarioRepository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService{
		
	private UsuarioRepository usuarioRepository;
	public ImplementsUserDetailsService(UsuarioRepository ur) {
		this.usuarioRepository = ur;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuarios usuario = usuarioRepository.findByEmail(email);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		return usuario;
	}

}
