package com.bodyFitnessGym.model.entity;

public class Administrador {

	private String id;
	private String nombre;
	private String dni;
	private String usuario;
	private String contrasena;

	public Administrador() {
		super();
	}

	public Administrador(String id, String nombre, String dni, String usuario, String contrasena) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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