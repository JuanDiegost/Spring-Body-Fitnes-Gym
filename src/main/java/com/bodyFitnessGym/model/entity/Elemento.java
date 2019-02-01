package com.bodyFitnessGym.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Elemento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idElemento;
	private Long nombre;
	private Long descripcion;
	public Long getIdElemento() {
		return idElemento;
	}
	public void setIdElemento(Long idElemento) {
		this.idElemento = idElemento;
	}
	public Long getNombre() {
		return nombre;
	}
	public void setNombre(Long nombre) {
		this.nombre = nombre;
	}
	public Long getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(Long descripcion) {
		this.descripcion = descripcion;
	}
}