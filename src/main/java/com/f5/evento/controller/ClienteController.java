package com.f5.evento.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.f5.evento.model.Cliente;
import com.f5.evento.service.ClienteService;

@Controller
@CrossOrigin("http://localhost:4200")
public class ClienteController {
	
	private ClienteService clienteService;
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@RequestMapping(value="/clientes", method = RequestMethod.GET)
	private ResponseEntity<List<Cliente>> getClientes(){
		return new ResponseEntity<>(clienteService.buscar(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/addCliente", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
		Cliente cadastro = clienteService.salvar(cliente);
		return new ResponseEntity<>(cadastro, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/editCliente", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Cliente> editCliente(@RequestBody Cliente cliente){
		Cliente clienteEditado = clienteService.salvar(cliente);
		return new ResponseEntity<>(clienteEditado, HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteCliente/{id}", method = RequestMethod.DELETE)
	private ResponseEntity<Cliente> editCliente(@PathVariable Long id){
		clienteService.excluir(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

