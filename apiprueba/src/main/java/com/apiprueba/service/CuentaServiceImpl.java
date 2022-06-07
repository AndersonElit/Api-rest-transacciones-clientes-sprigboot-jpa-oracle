package com.apiprueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiprueba.model.Cuenta;
import com.apiprueba.repository.dao.CuentaRepository;
import com.apiprueba.repository.op.CuentaOp;

@Service
public class CuentaServiceImpl implements CuentaService {
	
	@Autowired
	CuentaRepository repo;

	@Override
	public List<Cuenta> obtenerCuentas() {
		return repo.findAll();
	}
	
	public Cuenta obtenerCuenta(Long id) {
		Optional<Cuenta> cuenta = repo.findById(id);		
		return cuenta.get();
	}
	
	public void insertarCuenta(Cuenta cuenta) {
		CuentaOp.InsertarCuenta(cuenta);
	}
	
	public void eliminarCuenta(Long id) {
		CuentaOp.eliminarCuenta(id);
	}

}
