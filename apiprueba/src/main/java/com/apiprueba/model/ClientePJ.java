package com.apiprueba.model;

public class ClientePJ {
	
	private String razonSocial;
	private int fundacion;
	private int rut;
	
	public ClientePJ(String razonSocial, int fundacion, int rut) {
		this.razonSocial = razonSocial;
		this.fundacion = fundacion;
		this.rut = rut;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public int getFundacion() {
		return fundacion;
	}

	public void setFundacion(int fundacion) {
		this.fundacion = fundacion;
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

}
