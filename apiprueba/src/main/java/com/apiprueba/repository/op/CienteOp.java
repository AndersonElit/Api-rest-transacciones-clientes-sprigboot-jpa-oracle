package com.apiprueba.repository.op;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apiprueba.model.Customer;

@Repository
public class CienteOp {
	
	private static EntityManager entityManager;
	
	@Autowired
    public void ProcedureInvoker(final EntityManager entityManager) {
		this.entityManager = entityManager;
    }
	
	public static List<Customer> listaClientes(){
		
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("pk_customer.obtener_clientes", Customer.class);
		
		procedureQuery.registerStoredProcedureParameter("lista_clientes", void.class, ParameterMode.REF_CURSOR);
		procedureQuery.execute();
		
		@SuppressWarnings("unchecked")
		List<Customer> listaClientes = procedureQuery.getResultList();
		
		return listaClientes;
		
	}
	
	public static void insertarCliente(Customer customer) {
		
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("pk_customer.insertar_cliente", Customer.class);
		
		procedureQuery.registerStoredProcedureParameter("nombre_in", String.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("apellido_in", String.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("tipo_documento_in", String.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("numero_documento_in", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("rut_in", String.class, ParameterMode.IN);
		
		procedureQuery.setParameter("nombre_in", customer.getNombre());
		procedureQuery.setParameter("apellido_in", customer.getApellido());
		procedureQuery.setParameter("tipo_documento_in", customer.getTipoDocumento());
		procedureQuery.setParameter("numero_documento_in", customer.getNumeroDocumento());
		procedureQuery.setParameter("rut_in", customer.getRut());
		
		procedureQuery.execute();
		
	}

}
