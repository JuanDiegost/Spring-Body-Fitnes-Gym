package com.bodyFitnessGym.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Administrador {

	@Id
	private String dni;
	private String nombre;
	private String usuario;
	private String contrasena;
	
	public Administrador() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}