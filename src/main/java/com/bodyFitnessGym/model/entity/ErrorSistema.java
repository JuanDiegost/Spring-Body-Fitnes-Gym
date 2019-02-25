package com.bodyFitnessGym.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ErrorSistema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idError;
	@Column( length = 100000 )
	private String descripcionError;

	public Long getIdError() {
		return idError;
	}
	public void setIdError(Long idPregunta) {
		this.idError = idPregunta;
	}
	public String getDescripcionError() {
		return descripcionError;
	}
	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}
}