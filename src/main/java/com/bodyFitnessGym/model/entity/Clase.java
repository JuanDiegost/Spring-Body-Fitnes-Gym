package com.bodyFitnessGym.model.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;

@Entity
public class Clase {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idClase;
	private Date dia;
	private Time horaInicio;
	private Time horaFin;
	private String descripcion;
	private int numeroCupos;
	
	@OneToOne
	private Entrenador entrendor;
	
	@ManyToOne
	private Servicio servicio;
	
	@OneToMany
	private List<Alumno> asistencia;

	public Clase() {
		super();
	}

	public void addAsistencia(Alumno alumno) {
		this.asistencia.add(alumno);
	}
	
	//--------Getters&Setters---------------------
	
	public Long getIdClase() {
		return idClase;
	}

	public void setIdClase(Long idClase) {
		this.idClase = idClase;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumeroCupos() {
		return numeroCupos;
	}

	public void setNumeroCupos(int numeroCupos) {
		this.numeroCupos = numeroCupos;
	}

	public Entrenador getEntrendor() {
		return entrendor;
	}

	public void setEntrendor(Entrenador entrendor) {
		this.entrendor = entrendor;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public List<Alumno> getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(List<Alumno> asistencia) {
		this.asistencia = asistencia;
	}
	

}
