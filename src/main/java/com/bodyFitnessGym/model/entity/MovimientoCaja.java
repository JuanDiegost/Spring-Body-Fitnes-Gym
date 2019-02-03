package com.bodyFitnessGym.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class MovimientoCaja {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idMovimiento;
	private String descripcionMovimiento;
	private double valor;
	private String tipo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH:mm:ss", timezone="GMT-5")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaMovimiento;
	

	public MovimientoCaja() {
		super();
	}

	//--------------Getters&Setters-------------------
	
	public Long getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Long idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public String getDescripcionMovimiento() {
		return descripcionMovimiento;
	}

	public void setDescripcionMovimiento(String descripcionMovimiento) {
		this.descripcionMovimiento = descripcionMovimiento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

}
