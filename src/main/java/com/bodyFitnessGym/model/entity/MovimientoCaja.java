package com.bodyFitnessGym.model.entity;

public class MovimientoCaja {

	private String id;
	private String descripcion;
	private String tipo;
	private double valor;
	private Subscripcion subscripcion;

	public MovimientoCaja(String id, String descripcion, String tipo, double valor, Subscripcion subscripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.valor = valor;
		this.subscripcion = subscripcion;
	}

	public MovimientoCaja() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Subscripcion getSubscripcion() {
		return subscripcion;
	}

	public void setSubscripcion(Subscripcion subscripcion) {
		this.subscripcion = subscripcion;
	}

}
