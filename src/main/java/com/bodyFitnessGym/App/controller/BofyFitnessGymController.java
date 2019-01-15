package com.bodyFitnessGym.App.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bodyFitnessGym.manager.Manager;
import com.bodyFitnessGym.model.entity.Alumno;
import com.bodyFitnessGym.persistence.JsonManager;

@RestController
public class BofyFitnessGymController {

	@RequestMapping(value="/se",method=RequestMethod.GET)
	public String helloWorld() {
		Manager  manager=new Manager();
		manager.init();
		return JsonManager.toJson(manager.getSe());
	}
	
	@RequestMapping(value="/alumnos",method=RequestMethod.GET)
	public String getAlumnos() {
		Manager  manager=new Manager();
		manager.init();
		return JsonManager.toJson(manager.getA());
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String createPerson(@Valid @RequestBody Alumno p) {
		return JsonManager.toJson(p);
	}
}
