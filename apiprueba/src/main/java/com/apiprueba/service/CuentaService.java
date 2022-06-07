package com.apiprueba.service;

import java.util.List;
import com.apiprueba.model.Cuenta;

public interface CuentaService {
	
	public List<Cuenta> obtenerCuentas();
	
	public Cuenta obtenerCuenta(Long id);
	
	public void insertarCuenta(Cuenta cuenta);
	
	public void eliminarCuenta(Long id);

}
