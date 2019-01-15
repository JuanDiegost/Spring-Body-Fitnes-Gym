package com.bodyFitnessGym.model.entity;

import java.sql.Date;

public class Progreso {

	private String id;
	private String nombre;
	private String unidadMedida;
	private double informe;
	private Date fecha;

	public Progreso() {
		super();
	}

	public Progreso(String id, String nombre, String unidadMedida, double informe, Date fecha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.unidadMedida = unidadMedida;
		this.informe = informe;
		this.fecha = fecha;
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

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public double getInforme() {
		return informe;
	}

	public void setInforme(double informe) {
		this.informe = informe;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
