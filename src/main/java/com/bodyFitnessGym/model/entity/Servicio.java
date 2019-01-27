package com.bodyFitnessGym.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idServicio;
	private String nombreServicio;
	private String descripcionServicio;
	private double precio;
	private String tipoServicio;
	
	@OneToMany
	private List<Clase> clases;
	
	public Servicio() {
		super();
	}
	
	public void addClase(Clase clase) {
		this.clases.add(clase);
	}
		
	//--------getter&setters-------------------------
	
	public Long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public List<Clase> getHorario() {
		return clases;
	}

	public void setHorario(List<Clase> clases) {
		this.clases = clases;
	}
}