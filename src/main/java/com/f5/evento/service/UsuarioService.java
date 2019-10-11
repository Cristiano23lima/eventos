package com.f5.evento.service;

import org.springframework.stereotype.Service;

import com.f5.evento.model.Usuarios;
import com.f5.evento.repository.UsuarioRepository;

@Service
public class UsuarioService {
	private UsuarioRepository usuarioRep;
	public UsuarioService(UsuarioRepository usuarioRep) {
		this.usuarioRep = usuarioRep;
	}
	
	public Usuarios salvar(Usuarios usuario) {
		return usuarioRep.save(usuario);
	}	
}
