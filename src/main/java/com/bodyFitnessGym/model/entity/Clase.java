package com.bodyFitnessGym.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Clase {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idClase;
	private String descripcion;
	private int numeroCupos;
	
	@OneToMany
	private List<Horario> horarioClase;
	
	@ManyToMany
	private List<Elemento> elementoClase;

	@OneToOne
	private Entrenador entrendor;
	
	public Clase() {
		super();
	}

	public void addHorario(Horario clase) {
		this.horarioClase.add(clase);
	}
	
	public void addElemento(Elemento elemento) {
		//Todo
		this.elementoClase.add(elemento);
	}
	
	//--------Getters&Setters---------------------
	
	public Long getIdClase() {
		return idClase;
	}

	public void setIdClase(Long idClase) {
		this.idClase = idClase;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Horario> getHorarioClase() {
		return horarioClase;
	}

	public void setHorarioClase(List<Horario> horarioClase) {
		this.horarioClase = horarioClase;
	}

	public Entrenador getEntrendor() {
		return entrendor;
	}

	public void setEntrendor(Entrenador entrendor) {
		this.entrendor = entrendor;
	}

	public int getNumeroCupos() {
		return numeroCupos;
	}

	public void setNumeroCupos(int numeroCupos) {
		this.numeroCupos = numeroCupos;
	}
}