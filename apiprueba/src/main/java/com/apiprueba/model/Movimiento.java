package com.apiprueba.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIMIENTOS")
public class Movimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOV_SEQ")
	@SequenceGenerator(sequenceName = "movimientos_seq", name = "MOV_SEQ")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "numero_cuenta")
	private Long numeroCuenta;
	
	@Column(name = "valor")
	private Long valor;
	
	@Column(name = "estado")
	private String estado;
	
	public Movimiento() {
		
	}

	public Movimiento(Long id, Long numeroCuenta, Long valor, String estado) {
		this.id = id;
		this.numeroCuenta = numeroCuenta;
		this.valor = valor;
		this.estado = estado;
	}

	public Movimiento(Long id, Long numeroCuenta, Long valor) {
		this.id = id;
		this.numeroCuenta = numeroCuenta;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
