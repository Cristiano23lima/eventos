package com.f5.evento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.f5.evento.model.Eventos;
import com.f5.evento.repository.EventoRepository;

@Service
public class EventoService {
	
	EventoRepository eventoRep;
	public EventoService(EventoRepository eventoRep) {
		this.eventoRep = eventoRep;
	}
	
	public Eventos salvar(Eventos evento) {//cadastra e alterar os dados
		return eventoRep.save(evento);
	}
	
	public void excluir(Long id) {//excluir o dados do evento(imcompleto pois falta a exclusao das relações)
		eventoRep.deleteById(id);
	}
	
	public List<Eventos> buscarEventos(){
		return (List<Eventos>) eventoRep.findAll();
	}
}
