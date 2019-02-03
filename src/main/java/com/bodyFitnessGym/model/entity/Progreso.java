package com.bodyFitnessGym.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Progreso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProgreso;
	private String nombreProgreso;
	private String unidadMedida;
	

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
}