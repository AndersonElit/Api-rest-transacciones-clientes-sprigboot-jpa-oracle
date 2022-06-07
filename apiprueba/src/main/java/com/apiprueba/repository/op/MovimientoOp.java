package com.apiprueba.repository.op;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apiprueba.model.Movimiento;

@Repository
public class MovimientoOp {
	
	private static EntityManager entityManager;
	
	@Autowired
    public void ProcedureInvoker(final EntityManager entityManager) {
		this.entityManager = entityManager;
    }
	
	public static void insertarMovimiento(Movimiento movimiento) {
		
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("pk_customer.insertar_movimiento", Movimiento.class);
		
		procedureQuery.registerStoredProcedureParameter("numero_cuenta_in", Long.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("valor_in", Long.class, ParameterMode.IN);
		
		procedureQuery.setParameter("numero_cuenta_in", movimiento.getNumeroCuenta());
		procedureQuery.setParameter("valor_in", movimiento.getValor());
		
		procedureQuery.execute();
		
	}

}
