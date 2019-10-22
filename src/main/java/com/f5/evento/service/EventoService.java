package com.f5.evento.service;

import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.f5.evento.config.CloudinaryConfig;
import com.f5.evento.model.Eventos;
import com.f5.evento.model.Usuarios;
import com.f5.evento.repository.EventoRepository;

@Service
public class EventoService {
	
	EventoRepository eventoRep;
	CloudinaryConfig cdn;
	AlternativeService alternative;
	public EventoService(EventoRepository eventoRep, CloudinaryConfig CDN, AlternativeService as) {
		this.eventoRep = eventoRep;
		this.cdn = CDN;
		this.alternative = as;
	}
	
	public Eventos salvar(Eventos evento) {//cadastra e alterar os dados
		return eventoRep.save(evento);
	}
	
	public void excluir(Long id) {//excluir o dados do evento(imcompleto pois falta a exclusao das relações)
		eventoRep.deleteById(id);
	}
	
	public Iterable<Eventos> buscarEventos(){		
		return (Iterable<Eventos>) eventoRep.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
	}
	
	public Iterable<Eventos> buscarEventosUsuario(Usuarios usuario){
		return (Iterable<Eventos>) eventoRep.findByUsuario(usuario);
	}
	
	public Optional<Eventos> buscarEventoId(Long id){
		return eventoRep.findById(id);
	}
}
