package com.apiprueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apiprueba.model.Cuenta;
import com.apiprueba.service.CuentaService;

@RestController
public class CuentasController {
	
	@Autowired
	CuentaService cuentaService;
	
	@GetMapping("/cuentas")
	public List<Cuenta> obtenerCuentas(){
		return cuentaService.obtenerCuentas();
	}
	
	@GetMapping("/clientes/cuenta/{id}")
	public Cuenta obtenerCuenta(@PathVariable Long id) {
		Cuenta cuenta = cuentaService.obtenerCuenta(id);
		return cuenta;
	}
	
	@PostMapping("/clientes/cuenta/insertar")
	public void insertarCuenta(@RequestBody Cuenta cuenta) {
		cuentaService.insertarCuenta(cuenta);
	}
	
	@DeleteMapping("/clientes/cuenta/eliminar/{id}")
	public void eliminarCuenta(@PathVariable Long id) {
		cuentaService.eliminarCuenta(id);
	}

}
