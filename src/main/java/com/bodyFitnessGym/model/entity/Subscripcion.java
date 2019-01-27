package com.bodyFitnessGym.model.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Subscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSuscripcion;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH:mm:ss", timezone="GMT-5")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH:mm:ss", timezone="GMT-5")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFin;
	private int sesiones;
	private double precioSuscripcion;

	@OneToOne
	private MovimientoCaja movimientoDeCaja;

	@OneToOne
	private Servicio servicio;
	
	public Subscripcion() {
		super();
	}

	//------getters&Setters---------------------
	
	public Long getIdSuscripcion() {
		return idSuscripcion;
	}

	public void setIdSuscripcion(Long idSuscripcion) {
		this.idSuscripcion = idSuscripcion;
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

	public int getSesiones() {
		return sesiones;
	}

	public void setSesiones(int sesiones) {
		this.sesiones = sesiones;
	}

	public double getPrecioSuscripcion() {
		return precioSuscripcion;
	}

	public void setPrecioSuscripcion(double precioSuscripcion) {
		this.precioSuscripcion = precioSuscripcion;
	}

	public MovimientoCaja getMovimientoDeCaja() {
		return movimientoDeCaja;
	}

	public void setMovimientoDeCaja(MovimientoCaja movimientoDeCaja) {
		this.movimientoDeCaja = movimientoDeCaja;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
}