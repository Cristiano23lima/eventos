package com.f5.evento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.f5.evento.model.Cliente;
import com.f5.evento.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	public ClienteService(ClienteRepository cliente) {
		this.clienteRepository = cliente;
	}
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> buscar(){
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
	
}