package com.apiprueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiprueba.model.Movimiento;
import com.apiprueba.repository.dao.MovimientoRepository;
import com.apiprueba.repository.op.MovimientoOp;

@Service
public class MovimientoServiceImpl implements MovimientoService{
	
	@Autowired
	MovimientoRepository repo;

	@Override
	public List<Movimiento> listaMovimientos() {
		return repo.findAll();
	}
	
	public void insertarMovimiento(Movimiento movimiento) {
		MovimientoOp.insertarMovimiento(movimiento);
	}

}
