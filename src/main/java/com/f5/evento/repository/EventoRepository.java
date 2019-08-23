package com.f5.evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f5.evento.model.Eventos;

@Repository
public interface EventoRepository extends JpaRepository<Eventos, Long> {}
