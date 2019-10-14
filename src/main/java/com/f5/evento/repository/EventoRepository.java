package com.f5.evento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f5.evento.model.Eventos;
import com.f5.evento.model.Usuarios;

@Repository
public interface EventoRepository extends JpaRepository<Eventos, Long> {
	List<Eventos> findByUsuario(Usuarios usuario);
}
