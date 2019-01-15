package com.bodyFitnessGym.App.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bodyFitnessGym.manager.Manager;
import com.bodyFitnessGym.model.entity.Alumno;
import com.bodyFitnessGym.persistence.JsonManager;

@RestController
public class BodyFitnessGymController {

	@RequestMapping(value="/servicios",method=RequestMethod.GET)
	public String helloWorld() {
		Manager  manager=Manager.getInstance();
		manager.init();
		return JsonManager.toJson(manager.getSe());
	}
	
	@RequestMapping(value="/alumnos",method=RequestMethod.GET)
	public String getAlumnos() {
		Manager  manager=Manager.getInstance();
		manager.init();
		return JsonManager.toJson(manager.getA());
	}
	
	@RequestMapping(value="/alumno/{id}",method=RequestMethod.GET)
	public String getAlumno(@PathVariable String id) {
		Manager  manager=Manager.getInstance();
		manager.init();
		for (Alumno a : manager.getA()) {
			if(a.getId().equalsIgnoreCase(id)) return JsonManager.toJson(a);
		}
		return "No se encontro al estudiante";
	}
	
	@RequestMapping(value="/alumno/{id}",method=RequestMethod.DELETE)
	public String deletAlumno(@PathVariable String id) {
		Manager  manager=Manager.getInstance();
		manager.init();
		for (Alumno a : manager.getA()) {
			if(a.getId().equalsIgnoreCase(id)) {
				manager.remove(a);
				return JsonManager.toJson(a);	
			}
		}
		return "No se encontro al estudiante";
	}
	
	@RequestMapping(value="/alumno",method=RequestMethod.PUT)
	public String updateAlumno(@Valid @RequestBody Alumno p) {
		Manager manager=Manager.getInstance();
		manager.add(p);
		return JsonManager.toJson(p);
	}
	
	@RequestMapping(value="/alumno",method=RequestMethod.POST)
	public String createAlumno(@Valid @RequestBody Alumno p) {
		Manager manager=Manager.getInstance();
		manager.getA().add(p);
		return JsonManager.toJson(p);
	}
}
