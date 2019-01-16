package com.bodyFitnessGym.model.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Subscripcion {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private Date fechaInicio;
	private Date fechaFin;
	private int numeroSeciones;
	@ManyToOne
	private Servicio servicio;

	public Subscripcion(String id, Date fechaInicio, Date fechaFin, int numeroSeciones,Servicio servicio) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.numeroSeciones = numeroSeciones;
		this.servicio=servicio;
	}

	public Subscripcion() {
		super();
	}
	

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getNumeroSeciones() {
		return numeroSeciones;
	}

	public void setNumeroSeciones(int numeroSeciones) {
		this.numeroSeciones = numeroSeciones;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	
}
