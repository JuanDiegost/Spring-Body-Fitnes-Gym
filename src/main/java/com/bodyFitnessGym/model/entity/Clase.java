package com.bodyFitnessGym.model.entity;

public class Clase {

	private String id;
	private String nombre;
	private String descripcion;
	private int numeroCupos;
	private String dia;
	private String horaInicio;
	private String horaFin;
	private Servicio servicio;

	public Clase(String id, String nombre, String descripcion, int numeroCupos, String dia, String horaInicio,
			String horaFin, Servicio servicio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.numeroCupos = numeroCupos;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.servicio = servicio;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumeroCupos() {
		return numeroCupos;
	}

	public void setNumeroCupos(int numeroCupos) {
		this.numeroCupos = numeroCupos;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Clase() {
		super();
	}

}
