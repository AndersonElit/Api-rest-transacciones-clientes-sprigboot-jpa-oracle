package com.apiprueba.service;

import java.util.List;

import com.apiprueba.model.Customer;

public interface CustomerService {
	
	public List<Customer> obtenerClientes();
	
	public void insertarCliente(Customer customer);
	
	public Customer obtenerCliente(Long id);
	
	public void eliminarCliente(Long id);
	
	public void actualizarCliente(Customer customer);

}
