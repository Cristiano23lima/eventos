package com.f5.evento.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.f5.evento.model.Eventos;
import com.f5.evento.service.EventoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/evento")
public class EventosController {
	
	private EventoService eventoService;
	public EventosController(EventoService evento) {
		this.eventoService = evento;
	}
	
	@RequestMapping(value = "/addEvento", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Eventos> addEvento(@RequestBody Eventos evento){
		return new ResponseEntity<>(eventoService.salvar(evento), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/listEvento", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Eventos>> listaEvento(){
		return new ResponseEntity<>(eventoService.buscarEventos(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/editEvento", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Eventos> editEvento(@RequestBody Eventos evento){
		return new ResponseEntity<>(eventoService.salvar(evento), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/deleteEvento", method = RequestMethod.DELETE)
	public ResponseEntity<Eventos> deleteEvento(@PathVariable Long id){
		eventoService.excluir(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
