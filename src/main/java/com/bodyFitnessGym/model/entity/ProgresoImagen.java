package com.bodyFitnessGym.model.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProgresoImagen {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String url;
	private Date fechaProgresoImagen;
	private double masaCorporal;
	private double grasaCorporal;
	private double clusterCuerpo;
	private double clusterSombra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaProgresoImagen() {
		return fechaProgresoImagen;
	}

	public void setFechaProgresoImagen(Date fechaProgresoImagen) {
		this.fechaProgresoImagen = fechaProgresoImagen;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getMasaCorporal() {
		return masaCorporal;
	}

	public void setMasaCorporal(double masaCorporal) {
		this.masaCorporal = masaCorporal;
	}

	public double getGrasaCorporal() {
		return grasaCorporal;
	}

	public void setGrasaCorporal(double grasaCorporal) {
		this.grasaCorporal = grasaCorporal;
	}

	public double getClusterCuerpo() {
		return clusterCuerpo;
	}

	public void setClusterCuerpo(double clusterCuerpo) {
		this.clusterCuerpo = clusterCuerpo;
	}

	public double getClusterSombra() {
		return clusterSombra;
	}

	public void setClusterSombra(double clusterSombra) {
		this.clusterSombra = clusterSombra;
	}
}
