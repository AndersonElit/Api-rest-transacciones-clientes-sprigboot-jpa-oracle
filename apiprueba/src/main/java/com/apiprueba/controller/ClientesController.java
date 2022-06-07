package com.apiprueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apiprueba.model.Customer;
import com.apiprueba.repository.dao.ClienteDao;
import com.apiprueba.service.CustomerService;

@RestController
public class ClientesController {
	
	@Autowired
	ClienteDao clienteDao;
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/clientes")
	public List<Customer> obtenerClientes(){
		return customerService.obtenerClientes();
		
	}
	
	@GetMapping("/clientes/cliente/{id}")
	public Customer obtenerCliente(@PathVariable Long id) {
		Customer cliente = customerService.obtenerCliente(id);
		return cliente;
	}
	
	@PostMapping("/clientes/cliente/insertar")
	public void guardarCliente(@RequestBody Customer cliente) {
		customerService.insertarCliente(cliente);
	}
	
	@DeleteMapping("/clientes/cliente/eliminar/{id}")
	public void eliminarCliente(@PathVariable Long id) {
		customerService.eliminarCliente(id);
	}
	
	@PutMapping("/clientes/cliente/actualizar")
	public void actualizarCliente(@RequestBody Customer cliente) {
		customerService.actualizarCliente(cliente);
	}

}
