package com.bodyFitnessGym.reports;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.expression.ParseException;

import com.bodyFitnessGym.model.entity.Alumno;
import com.bodyFitnessGym.model.entity.ProgresoImagen;
import com.ibm.icu.util.GregorianCalendar;
import com.mashape.unirest.http.exceptions.UnirestException;

import net.sf.jasperreports.engine.JRException;

public class TestReports {
	
	public static void main(String[] args) {
		
		Alumno alumno=new Alumno();
		alumno.setNombreAlumno("Jose Perez");
		alumno.setUrlImagenUsuario("https://firebasestorage.googleapis.com/v0/b/body-fitnes-gym.appspot.com/o/uploads%2Fwmtnm1550183959121.png?alt=media&token=0a46d5ef-d50c-4f95-b828-eb3be8b65a7b");
		alumno.setDniAlumno(712731L);
		List<ProgresoImagen> imagens=new ArrayList<ProgresoImagen>();
		ProgresoImagen p1=new ProgresoImagen();
		p1.setId(1L);
		p1.setFechaProgresoImagen(new GregorianCalendar(2018, 10, 22).getTime());
		p1.setUrl("https://i.imgur.com/NX4mLIk.jpg");
		p1.setMasaCorporal(28);
		p1.setGrasaCorporal(8);

		ProgresoImagen p2=new ProgresoImagen();
		p2.setId(2L);
		p2.setFechaProgresoImagen(new GregorianCalendar(2018, 11, 22).getTime());
		p2.setUrl("https://i.imgur.com/q4xSkgO.jpg");
		p2.setMasaCorporal(30.4);
		p2.setGrasaCorporal(5.1);
		
		ProgresoImagen p3=new ProgresoImagen();
		p3.setId(3L);
		p3.setFechaProgresoImagen(new GregorianCalendar(2019, 1, 22).getTime());
		p3.setUrl("https://i.imgur.com/C8Nd78D.jpg");
		p3.setMasaCorporal(30.45);
		p3.setGrasaCorporal(5.08);

		imagens.add(p1);
		imagens.add(p2);
		imagens.add(p3);

		alumno.setProgresoImagen(imagens);
		
		try {
			Reports.generarProgresosPDF(alumno);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
