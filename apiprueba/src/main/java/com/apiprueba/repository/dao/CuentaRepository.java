package com.apiprueba.repository.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.apiprueba.model.Cuenta;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, Long>{
	
	List<Cuenta> findAll();

}
