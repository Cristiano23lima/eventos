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

import com.f5.evento.model.Cliente;
import com.f5.evento.service.ClienteService;

@CrossOrigin(origins = "*")
@RestController
public class ClienteController {
	
	private ClienteService clienteService;
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@RequestMapping(value="/cliente", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private ResponseEntity<List<Cliente>> getClientes(){
		return new ResponseEntity<>(clienteService.buscar(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/cliente", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
		Cliente cadastro = clienteService.salvar(cliente);
		return new ResponseEntity<>(cadastro, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/cliente", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Cliente> editCliente(@RequestBody Cliente cliente){
		Cliente clienteEditado = clienteService.salvar(cliente);
		return new ResponseEntity<>(clienteEditado, HttpStatus.OK);
	}
	
	@RequestMapping(value="/cliente/{id}", method = RequestMethod.DELETE)
	private ResponseEntity<Cliente> editCliente(@PathVariable Long id){
		clienteService.excluir(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

