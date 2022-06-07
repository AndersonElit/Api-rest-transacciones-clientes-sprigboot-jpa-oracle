package com.apiprueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apiprueba.model.Movimiento;
import com.apiprueba.service.MovimientoService;

@RestController
public class MovimientoController {
	
	@Autowired
	MovimientoService service;
	
	@GetMapping("/movimientos")
	public List<Movimiento> obtenerMovimientos(){
		return service.listaMovimientos();
	}
	
	@PostMapping("/clientes/movimiento/insertar")
	public void insertarMovimiento(@RequestBody Movimiento movimiento) {
		service.insertarMovimiento(movimiento);		
	}

}
