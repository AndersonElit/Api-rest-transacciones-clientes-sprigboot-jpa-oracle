package com.apiprueba.repository.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apiprueba.model.Movimiento;

@Repository
public interface MovimientoRepository extends CrudRepository<Movimiento, Long>{
	
	public List<Movimiento> findAll();

}
