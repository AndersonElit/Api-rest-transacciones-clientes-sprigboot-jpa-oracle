package com.apiprueba.service;

import java.util.List;

import com.apiprueba.model.Movimiento;

public interface MovimientoService {
	
	public List<Movimiento> listaMovimientos();
	
	public void insertarMovimiento(Movimiento movimiento);

}
