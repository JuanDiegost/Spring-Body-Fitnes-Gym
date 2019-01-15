package com.bodyFitnessGym.model.entity;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bodyFitnessGym.persistence.DataBaseAcces;

public class Alumno {

	private String id;
	private String nombre;
	private String dni;
	private String telefono;
	private String email;
	private String usuario;
	private String contrasena;
	private Date fechaNacimiento;
	private char genero;
	private ArrayList<Subscripcion> subscripciones;
	private ArrayList<Pregunta> preguntas;
	private ArrayList<Progreso> progresos;

	public Alumno() {
		super();
	}

	public Alumno(String id, String nombre, String dni, String telefono, String email, String usuario,
			String contrasena, Date fechaNacimiento, char genero, ArrayList<Subscripcion> subscripciones,
			ArrayList<Pregunta> preguntas, ArrayList<Progreso> progresos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.subscripciones = new ArrayList<>();
		this.preguntas = new ArrayList<>();
		this.progresos = new ArrayList<>();
		for (Progreso progreso : progresos) {
			this.progresos.add(progreso);
		}
		for (Pregunta pregunta : preguntas) {
			this.preguntas.add(pregunta);
		}
		for (Subscripcion subscripcion : subscripciones) {
			this.subscripciones.add(subscripcion);
		}
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

	public ArrayList<Subscripcion> getSubscripciones() {
		return subscripciones;
	}

	public void setSubscripciones(ArrayList<Subscripcion> subscripciones) {
		this.subscripciones = subscripciones;
	}

	public void addSubscripcion(Subscripcion subscripcion) {
		subscripciones.add(subscripcion);
	}

	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public ArrayList<Progreso> getProgresos() {
		return progresos;
	}

	public void setProgresos(ArrayList<Progreso> progresos) {
		this.progresos = progresos;
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
		sta.setString(1, id);
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