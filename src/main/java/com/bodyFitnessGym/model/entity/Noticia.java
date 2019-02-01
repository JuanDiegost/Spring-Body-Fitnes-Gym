package com.bodyFitnessGym.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Noticia {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idNoticia;
	private String titular;
	private String contenido;
	private String urlImagen;
	
	public Long getIdNoticia() {
		return idNoticia;
	}
	public void setIdNoticia(Long idNoticia) {
		this.idNoticia = idNoticia;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
}