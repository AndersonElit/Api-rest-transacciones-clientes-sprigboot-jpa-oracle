package com.apiprueba.repository.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.apiprueba.model.Customer;

@Repository
@Transactional
public class ClienteDao {
	
	@PersistenceContext
	EntityManager em;
	
	static List<Customer> lista = new ArrayList<>();
	
	/*
	static {
		lista.add(new Customer(1, "anderson", "arrieta", "C", 1111111, "2333333"));
		lista.add(new Customer(2, "ander", "rodri", "E", 222222, "120000"));
	}
	*/
	
	public List<Customer> obtenerClientes(){
		return lista;
	}
	
	public Customer obtenerCliente(int clienteId) {
		return lista.stream().filter(cli -> cli.getClienteId()==clienteId).findAny().orElse(null);
	}
	
	public void guardarCliente(Customer cliente) {
		em.persist(cliente);
	}

}
