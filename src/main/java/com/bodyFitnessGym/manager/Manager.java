package com.bodyFitnessGym.manager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bodyFitnessGym.model.entity.Alumno;
import com.bodyFitnessGym.model.entity.Clase;
import com.bodyFitnessGym.model.entity.Servicio;
import com.bodyFitnessGym.model.entity.Subscripcion;
import com.bodyFitnessGym.persistence.DataBaseAcces;

public class Manager {

	private ArrayList<Servicio> se = new ArrayList<>();
	private ArrayList<Clase> clase = new ArrayList<>();
	private ArrayList<Alumno> a = new ArrayList<>();

	public void init() {
		Servicio servicio = new Servicio("1", "Sppining", "re lajate dhasbdas", 100000.0);
		Servicio servicio2 = new Servicio("2", "zamba", "re lajate dhasbdas", 100000.0);
		Servicio servicio3 = new Servicio("3", "baile", "re lajate dhasbdas", 100000.0);
		Servicio servicio4 = new Servicio("4", "asd", "re lajate dhasbdas", 100000.0);
		se.add(servicio);
		se.add(servicio2);
		se.add(servicio3);
		se.add(servicio4);
		Clase clase = new Clase("1", "spining clase 1", "relajate con", 20, "Lunes", "8:00 AM", "10:00 PM", servicio4);
		Clase clase2 = new Clase("2", "zamba clase 2", "relajate con", 20, "Lunes", "8:00 AM", "10:00 PM", servicio2);
		Clase clase3 = new Clase("3", "baile clase 2", "relajate con", 20, "Lunes", "8:00 AM", "10:00 PM", servicio3);
		this.clase.add(clase);
		this.clase.add(clase2);
		this.clase.add(clase3);
		Subscripcion subscripcion = new Subscripcion("1", new Date(234234), new Date(4324234), 0, servicio4);
		Alumno alumno = new Alumno("2", "sadas", "sdsds", "32423432", "sadas@adsa.com", "sad34", "adsadas",
				new Date(324234), 'M', new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		alumno.addSubscripcion(subscripcion);
		a.add(alumno);
	}

	public ArrayList<Servicio> getSe() {
		return se;
	}

	public void setSe(ArrayList<Servicio> se) {
		this.se = se;
	}

	public ArrayList<Clase> getClase() {
		return clase;
	}

	public void setClase(ArrayList<Clase> clase) {
		this.clase = clase;
	}

	public ArrayList<Alumno> getA() {
		return a;
	}

	public void setA(ArrayList<Alumno> a) {
		this.a = a;
	}

	public void listarAlumnos() {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			ResultSet resultset = DataBaseAcces.getInstance().getStatement().executeQuery("SELECT * FROM ALUMNOS");
			while (resultset.next()) {
				Alumno alumno = new Alumno();
				resultset.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}