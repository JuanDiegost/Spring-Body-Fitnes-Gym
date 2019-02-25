package com.bodyFitnessGym.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pregunta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPregunta;
	private String nombrePregunta;
	@Column( length = 100000 )
	private String descripcionPregunta;
	
	public Pregunta() {
		super();
	}
	public Long getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}
	public String getNombrePregunta() {
		return nombrePregunta;
	}
	public void setNombrePregunta(String nombrePregunta) {
		this.nombrePregunta = nombrePregunta;
	}
	public String getDescripcionPregunta() {
		return descripcionPregunta;
	}
	public void setDescripcionPregunta(String descripcionPregunta) {
		this.descripcionPregunta = descripcionPregunta;
	}
}