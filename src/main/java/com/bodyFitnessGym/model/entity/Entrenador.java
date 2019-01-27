package com.bodyFitnessGym.model.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Entrenador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEntrenador;
	private String dniEntrenador;
	private String nombreEntrenador;
	private String telefonoEntrenador;
	private String emailEntrenador;
	private String urlImagenEntrenador;
	private String usuarioEntrenador;
	private String contraseniaEntrenador;

	@ManyToMany
	private List<Servicio> entrenadorServicio;

	public Entrenador() {
		super();
	}
	
	public void addServicio(Servicio servicio) {
		this.entrenadorServicio.add(servicio);
	}

	//------------Getters&Setters---------------------------
	
	public Long getIdEntrenador() {
		return idEntrenador;
	}

	public void setIdEntrenador(Long idEntrenador) {
		this.idEntrenador = idEntrenador;
	}

	public String getDniEntrenador() {
		return dniEntrenador;
	}

	public void setDniEntrenador(String dniEntrenador) {
		this.dniEntrenador = dniEntrenador;
	}

	public String getNombreEntrenador() {
		return nombreEntrenador;
	}

	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}

	public String getTelefonoEntrenador() {
		return telefonoEntrenador;
	}

	public void setTelefonoEntrenador(String telefonoEntrenador) {
		this.telefonoEntrenador = telefonoEntrenador;
	}

	public String getEmailEntrenador() {
		return emailEntrenador;
	}

	public void setEmailEntrenador(String emailEntrenador) {
		this.emailEntrenador = emailEntrenador;
	}

	public String getUrlImagenEntrenador() {
		return urlImagenEntrenador;
	}

	public void setUrlImagenEntrenador(String urlImagenEntrenador) {
		this.urlImagenEntrenador = urlImagenEntrenador;
	}

	public String getUsuarioEntrenador() {
		return usuarioEntrenador;
	}

	public void setUsuarioEntrenador(String usuarioEntrenador) {
		this.usuarioEntrenador = usuarioEntrenador;
	}

	public String getContraseniaEntrenador() {
		return contraseniaEntrenador;
	}

	public void setContraseniaEntrenador(String contraseniaEntrenador) {
		this.contraseniaEntrenador = contraseniaEntrenador;
	}

	public List<Servicio> getEntrenadorServicio() {
		return entrenadorServicio;
	}

	public void setEntrenadorServicio(List<Servicio> entrenadorServicio) {
		this.entrenadorServicio = entrenadorServicio;
	}
}
