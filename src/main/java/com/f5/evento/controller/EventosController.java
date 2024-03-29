package com.f5.evento.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.f5.evento.config.CloudinaryConfig;
import com.f5.evento.model.Eventos;
import com.f5.evento.model.Usuarios;
import com.f5.evento.repository.UsuarioRepository;
import com.f5.evento.service.EventoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/evento")
public class EventosController {	
	private EventoService eventoService;
	private UsuarioRepository usuarioRepository;
	private CloudinaryConfig cdn;

	public EventosController(EventoService evento, UsuarioRepository UR, CloudinaryConfig CDN) {
		this.eventoService = evento;
		this.usuarioRepository = UR;
		this.cdn = CDN;
	}
	
	@RequestMapping(value = "/addEvento/{email}", method = RequestMethod.POST)
	public ResponseEntity<Eventos> addEvento(@PathVariable("email") String email, Eventos evento, @RequestParam("imagem") MultipartFile imagem){
		evento.setEndImagem(cdn.uploadFile(imagem));
		Usuarios usuario = usuarioRepository.findByEmail(email);
		evento.setUsuario(usuario);
		return new ResponseEntity<>(eventoService.salvar(evento), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/listEvento", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Iterable<Eventos>> listaEvento(){
		return new ResponseEntity<>(eventoService.buscarEventos(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listEventoUsuario/{email}", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Eventos>> listaEventoUsuario(@PathVariable("email") String email){
		Usuarios usuario = usuarioRepository.findByEmail(email);
		
		//busca os eventos pelo usuario
		Iterable<Eventos> eventos = eventoService.buscarEventosUsuario(usuario);
		
		//retorna msg de sucesso
		return new ResponseEntity<>(eventos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/editEvento", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Eventos> editEvento(@RequestBody Eventos evento){
		return new ResponseEntity<>(eventoService.salvar(evento), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/deleteEvento/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Eventos> deleteEvento(@PathVariable("id") Long id){
		eventoService.excluir(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/buscaEvento/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Eventos>> buscarEventoId(@PathVariable("id") Long id){
		return new ResponseEntity<>(eventoService.buscarEventoId(id), HttpStatus.OK);
	}
}
