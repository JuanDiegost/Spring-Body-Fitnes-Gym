package com.bodyFitnessGym.model.entity;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import org.springframework.data.annotation.Transient;
import com.bodyFitnessGym.persistence.JsonManager;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.mashape.unirest.http.exceptions.UnirestException;

@Entity
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "exception_seq_generator")
	@SequenceGenerator(name = "exception_seq_generator", sequenceName = "exception_seq", allocationSize = 1)
	private Long idAlumno;
	private String dniAlumno;
	private String nombreAlumno;
	private String telefonoAlumno;
	private String emailAlumno;
	private String urlImagenUsuario;
	private String usuarioAlumno;
	private String contrasenia;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT-5")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	private char genero;
	private String grupoSanguineo;

	@OneToMany(cascade = CascadeType.REMOVE)
	private List<Subscripcion> historialSuscripcion;

	@Transient
	private int position;

	@ManyToMany
	private List<Pregunta> historialMedico;

	@OneToMany(cascade = CascadeType.REMOVE)
	private List<Progreso> historialProgreso;

	@OneToMany(cascade = CascadeType.REMOVE)
	private List<ProgresoImagen> historialProgresoImagen;

	@ManyToMany
	private List<Horario> asistencia;

	public Alumno() {
		super();
	}

	public void addProgresoImagen(ProgresoImagen progresoImagen) throws UnirestException {
		ArrayList<Double> clusters = JsonManager.getClusterValues(progresoImagen.getUrl());
		progresoImagen.setClusterCuerpo(clusters.get(0));
		progresoImagen.setClusterSombra(clusters.get(1));
		if (historialProgresoImagen.size() == 0) {
			historialProgresoImagen.add(progresoImagen);
		} else {
			ProgresoImagen ultimoProgreso = historialProgresoImagen.get(historialProgresoImagen.size() - 1);
			progresoImagen.setMasaCorporal(((progresoImagen.getClusterCuerpo() + progresoImagen.getClusterSombra())
					* ultimoProgreso.getMasaCorporal())
					/ (ultimoProgreso.getClusterCuerpo() + ultimoProgreso.getClusterSombra()));
			progresoImagen
					.setGrasaCorporal(((1 / progresoImagen.getClusterSombra()) * ultimoProgreso.getGrasaCorporal())
							/ (1 / ultimoProgreso.getClusterSombra()));
			historialProgresoImagen.add(progresoImagen);
		}
	}
	
	// -------------getters&Setters-----------------------------
	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(String dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getTelefonoAlumno() {
		return telefonoAlumno;
	}

	public void setTelefonoAlumno(String telefonoAlumno) {
		this.telefonoAlumno = telefonoAlumno;
	}

	public String getEmailAlumno() {
		return emailAlumno;
	}

	public void setEmailAlumno(String emailAlumno) {
		this.emailAlumno = emailAlumno;
	}

	public String getUrlImagenUsuario() {
		return urlImagenUsuario;
	}

	public void setUrlImagenUsuario(String urlImagenUsuario) {
		this.urlImagenUsuario = urlImagenUsuario;
	}

	public String getUsuarioAlumno() {
		return usuarioAlumno;
	}

	public void setUsuarioAlumno(String usuarioAlumno) {
		this.usuarioAlumno = usuarioAlumno;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public List<Subscripcion> getHistorialSuscripcion() {
		return historialSuscripcion;
	}

	public void setHistorialSuscripcion(List<Subscripcion> historialSuscripcion) {
		this.historialSuscripcion = historialSuscripcion;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public List<Pregunta> getHistorialMedico() {
		return historialMedico;
	}

	public void setHistorialMedico(List<Pregunta> historialMedico) {
		this.historialMedico = historialMedico;
	}

	public List<Progreso> getHistorialProgreso() {
		return historialProgreso;
	}

	public void setHistorialProgreso(List<Progreso> historialProgreso) {
		this.historialProgreso = historialProgreso;
	}

	public List<ProgresoImagen> getHistorialProgresoImagen() {
		return historialProgresoImagen;
	}

	public void setHistorialProgresoImagen(List<ProgresoImagen> progresosImagen) {
		this.historialProgresoImagen = progresosImagen;
	}

	public List<Horario> getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(List<Horario> asistencia) {
		this.asistencia = asistencia;
	}

	public void addProgreso(@Valid Progreso p) {
		this.historialProgreso.add(p);
	}

	public void addSubscripcion(Subscripcion subscripcion) {
		this.historialSuscripcion.add(subscripcion);
	}

	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}
}