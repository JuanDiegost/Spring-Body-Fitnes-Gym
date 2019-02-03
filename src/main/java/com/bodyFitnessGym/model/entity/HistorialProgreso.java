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
public class HistorialProgreso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idHistorialProgreso;
	private double informe;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH:mm:ss", timezone="GMT-5")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPrgreso;

	@OneToOne
	private Progreso progreso;
	
	@OneToOne
	private Alumno alumno;

	public Long getIdHistorialProgreso() {
		return idHistorialProgreso;
	}

	public void setIdHistorialProgreso(Long idHistorialProgreso) {
		this.idHistorialProgreso = idHistorialProgreso;
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

	public Progreso getProgreso() {
		return progreso;
	}

	public void setProgreso(Progreso progreso) {
		this.progreso = progreso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
}