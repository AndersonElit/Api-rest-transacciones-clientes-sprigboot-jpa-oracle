package com.apiprueba.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CUENTAS")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUNT_SEQ")
	@SequenceGenerator(sequenceName = "cuentas_seq", name = "CUNT_SEQ")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nitcedula")
	private Long nitcedula;
	@Column(name = "numero_cuenta")
	private Long numeroCuenta;
	@Column(name = "moneda")
	private String moneda;
	@Column(name = "saldo")
	private Long saldo;
	
	public Cuenta() {
		
	}
	
	public Cuenta(Long id, Long nitcedula, Long numeroCuenta, String moneda, Long saldo) {
		super();
		this.id = id;
		this.nitcedula = nitcedula;
		this.numeroCuenta = numeroCuenta;
		this.moneda = moneda;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNitcedula() {
		return nitcedula;
	}
	public void setNitcedula(Long nitcedula) {
		this.nitcedula = nitcedula;
	}
	public Long getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Long getSaldo() {
		return saldo;
	}
	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}

}
