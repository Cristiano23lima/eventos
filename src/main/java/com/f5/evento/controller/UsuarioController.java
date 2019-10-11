package com.f5.evento.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.f5.evento.model.Usuarios;
import com.f5.evento.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

	private UsuarioService usuarioService;
	public UsuarioController(UsuarioService usuarioServ) {
		this.usuarioService = usuarioServ;
	}
	
	@RequestMapping(value="/usuario", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuarios> cadastrarUsuario(@RequestBody Usuarios usuario){
		Usuarios usuarioCadastrado = usuarioService.salvar(usuario);
		return new ResponseEntity<>(usuarioCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/usuario", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuarios> editarUsuario(@RequestBody Usuarios usuario){
		Usuarios usuarioEditado = usuarioService.salvar(usuario);
		return new ResponseEntity<>(usuarioEditado, HttpStatus.CREATED);
	}
}
