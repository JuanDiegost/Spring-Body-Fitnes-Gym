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
public class Progreso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProgreso;
	private String nombreProgreso;
	private String unidadMedida;
	private double informe;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT-5")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPrgreso;

	public Progreso() {
		super();
	}

	// ----------getters&Setters----------------------

	public Long getIdProgreso() {
		return idProgreso;
	}

	public void setIdProgreso(Long idProgreso) {
		this.idProgreso = idProgreso;
	}

	public String getNombreProgreso() {
		return nombreProgreso;
	}

	public void setNombreProgreso(String nombreProgreso) {
		this.nombreProgreso = nombreProgreso;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public double getInforme() {
		return informe;
	}

	public void setInforme(double informe) {
		this.informe = informe;
	}

	public Date getFechaPrgreso() {
		return fechaPrgreso;
	}

	public void setFechaPrgreso(Date fechaPrgreso) {
		this.fechaPrgreso = fechaPrgreso;
	}
}