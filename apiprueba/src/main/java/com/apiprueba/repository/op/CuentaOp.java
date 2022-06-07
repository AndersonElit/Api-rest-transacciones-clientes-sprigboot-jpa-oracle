package com.apiprueba.repository.op;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apiprueba.model.Cuenta;

@Repository
public class CuentaOp {
	
	private static EntityManager entityManager;
	
	@Autowired
    public void ProcedureInvoker(final EntityManager entityManager) {
		this.entityManager = entityManager;
    }
	
	public static void InsertarCuenta(Cuenta cuenta) {
		
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("pk_customer.insertar_cuenta", Cuenta.class);
		
		procedureQuery.registerStoredProcedureParameter("nitcedula_in", Long.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("numero_cuenta_in", Long.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("moneda_in", String.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("saldo_in", Long.class, ParameterMode.IN);
		
		procedureQuery.setParameter("nitcedula_in", cuenta.getNitcedula());
		procedureQuery.setParameter("numero_cuenta_in", cuenta.getNumeroCuenta());
		procedureQuery.setParameter("moneda_in", cuenta.getMoneda());
		procedureQuery.setParameter("saldo_in", cuenta.getSaldo());
		
		procedureQuery.execute();
		
	}
	
	public static void eliminarCuenta(Long id) {
		
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("pk_customer.eliminar_cuenta", Long.class);
		
		procedureQuery.registerStoredProcedureParameter("id_cuenta", Long.class, ParameterMode.IN);
		procedureQuery.setParameter("id_cuenta", id);
		procedureQuery.execute();		
		
	}

}
