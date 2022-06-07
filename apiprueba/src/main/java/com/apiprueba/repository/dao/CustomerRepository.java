package com.apiprueba.repository.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apiprueba.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	List<Customer> findAll();

}
