package com.bodyFitnessGym.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ErrorSistema {
	
	public static String USUARIO_NO_EXISTE = "No se encuentra usuario";
	public static String PROGRAMA_YA_EXISTE = "Nombre de programa repetido";
	public static String NOTICIA_YA_EXISTE = "Nombre de noticias repetido";
	public static String HORARIO_CRUZADO = "Norarios cruzados con el mismo entrenador";
	public static String USUARIO_EN_USO = "Nombre de usuario de en uso";

	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idError;
	private String descripcionError;
	
	public ErrorSistema(String descripcionError) {
		this.setDescripcionError(descripcionError);
	}
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