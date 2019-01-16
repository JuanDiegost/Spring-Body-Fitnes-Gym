package com.bodyFitnessGym.model.entity;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.bodyFitnessGym.persistence.DataBaseAcces;

@Entity
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String dni;
	private String telefono;
	private String email;
	private String usuario;
	private String contrasena;
	private Date fechaNacimiento;
	private char genero;

	@OneToMany(cascade = CascadeType.REMOVE)
	private List<Subscripcion> subscripciones;

	@OneToMany
	private List<Pregunta> preguntas;

	@OneToMany(cascade = CascadeType.REMOVE)
	private List<Progreso> progresos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Subscripcion> getSubscripciones() {
		return subscripciones;
	}

	public void setSubscripciones(ArrayList<Subscripcion> subscripciones) {
		this.subscripciones = subscripciones;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public List<Progreso> getProgresos() {
		return progresos;
	}

	public void setProgresos(ArrayList<Progreso> progresos) {
		this.progresos = progresos;
	}

	public void addSubscripcion(Subscripcion subscripcion) {
		subscripciones.add(subscripcion);
	}

	public void addPregunta(Pregunta pregunta) {
		preguntas.add(pregunta);
	}

	public void addProgreso(Progreso progreso) {
		progresos.add(progreso);
	}

	public void inserIntoDataBase() throws SQLException {
		PreparedStatement sta = DataBaseAcces.getInstance().getConnection()
				.prepareStatement("INSERT INTO ALUMNO VALUES(?,?,?,?,?,?,?,?,?)");
		sta.setLong(1, id);
		sta.setString(2, nombre);
		sta.setString(3, dni);
		sta.setString(4, telefono);
		sta.setString(5, email);
		sta.setString(6, usuario);
		sta.setString(7, contrasena);
		sta.setDate(8, fechaNacimiento);
		sta.setString(9, genero == 'M' ? "Masculino" : "Femenino");
		sta.execute();
	}

}