package com.apiprueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apiprueba.model.Customer;
import com.apiprueba.repository.dao.CustomerRepository;
import com.apiprueba.repository.op.CienteOp;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> obtenerClientes() {
		//A partir de procedimiento almacenado:
		//return CienteOp.listaClientes();
		//tambien se puede de forma automatica:
		return customerRepository.findAll();
	}

	@Override
	public void insertarCliente(Customer customer) {
		//A partir de procedimiento almacenado, asi se hizo para incluir la condicion de no insertar si ya existe el rut en la base de datos:
		CienteOp.insertarCliente(customer);		
	}
	
	public Customer obtenerCliente(Long id) {
		Optional<Customer> cliente = customerRepository.findById(id);		
		return cliente.get();
	}

	@Override
	public void eliminarCliente(Long id) {
		customerRepository.deleteById(id);
	}

	public void actualizarCliente(Customer customer) {
		boolean clienteExiste = customerRepository.existsById(customer.getClienteId());
		
		if (clienteExiste == true) {
			customerRepository.save(customer);
		} else {
			throw new RuntimeException("El cliente no existe");
		}
	}

}
