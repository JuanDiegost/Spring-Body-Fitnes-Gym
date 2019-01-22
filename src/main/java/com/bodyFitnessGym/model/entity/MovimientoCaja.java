package com.bodyFitnessGym.model.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MovimientoCaja {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String descripcion;
	private String tipo;
	private double valor;
	@OneToOne
	private Subscripcion subscripcion;
	private Date fecha;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
