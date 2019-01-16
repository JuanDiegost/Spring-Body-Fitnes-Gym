package com.bodyFitnessGym.App.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bodyFitnessGym.manager.Manager;
import com.bodyFitnessGym.model.entity.Alumno;
import com.bodyFitnessGym.model.entity.Clase;
import com.bodyFitnessGym.model.entity.Entrenador;
import com.bodyFitnessGym.model.entity.MovimientoCaja;
import com.bodyFitnessGym.model.entity.Pregunta;
import com.bodyFitnessGym.model.entity.Progreso;
import com.bodyFitnessGym.model.entity.Servicio;
import com.bodyFitnessGym.model.entity.Subscripcion;
import com.bodyFitnessGym.persistence.JsonManager;

@RestController
public class BodyFitnessGymController {

	// ----------Alumnos---------------------------------------//

	@RequestMapping(value = "/alumnos", method = RequestMethod.GET)
	public String getAlumnos() {
		Manager manager = Manager.getInstance();
		return JsonManager.toJson(manager.getA());
	}

	@RequestMapping(value = "/alumno/{id}", method = RequestMethod.GET)
	public String getAlumno(@PathVariable String id) {
		Manager manager = Manager.getInstance();
		for (Alumno a : manager.getA()) {
			if (a.getId().equalsIgnoreCase(id))
				return JsonManager.toJson(a);
		}
		return "No se encontro al estudiante";
	}

	@RequestMapping(value = "/alumno/{id}", method = RequestMethod.DELETE)
	public String deletAlumno(@PathVariable String id) {
		Manager manager = Manager.getInstance();
		for (Alumno a : manager.getA()) {
			if (a.getId().equalsIgnoreCase(id)) {
				manager.remove(a);
				return JsonManager.toJson(a);
			}
		}
		return "No se encontro al estudiante";
	}

	@RequestMapping(value = "/alumno", method = RequestMethod.PUT)
	public String updateAlumno(@Valid @RequestBody Alumno p) {
		Manager manager = Manager.getInstance();
		manager.add(p);
		return JsonManager.toJson(p);
	}

	@RequestMapping(value = "/alumno", method = RequestMethod.POST)
	public String createAlumno(@Valid @RequestBody Alumno p) {
		Manager manager = Manager.getInstance();
		System.out.println(p.getId());
		manager.add(p);
		return JsonManager.toJson(p);
	}

	// ----------Servicios---------------------------------------//

	@RequestMapping(value = "/servicios", method = RequestMethod.GET)
	public String getServicios() {
		return "servicios";
	}

	@RequestMapping(value = "/servicio/{id}", method = RequestMethod.GET)
	public String getServicio(@PathVariable String id) {
		return "servicios";
	}

	@RequestMapping(value = "/servicio/{id}", method = RequestMethod.DELETE)
	public String deletServicio(@PathVariable String id) {
		return "servicios";

	}

	@RequestMapping(value = "/servicio", method = RequestMethod.PUT)
	public String updateServicio(@Valid @RequestBody Servicio p) {
		return "servicios";
	}

	@RequestMapping(value = "/servicio", method = RequestMethod.POST)
	public String createServicio(@Valid @RequestBody Servicio p) {
		return "servicios";
	}

	// ----------Clases---------------------------------------//

	@RequestMapping(value = "/clases", method = RequestMethod.GET)
	public String getClases() {
		return "Clases";
	}

	@RequestMapping(value = "/clase/{id}", method = RequestMethod.GET)
	public String getClases(@PathVariable String id) {
		return "Clases";
	}

	@RequestMapping(value = "/clase/{id}", method = RequestMethod.DELETE)
	public String deletClases(@PathVariable String id) {
		return "Clases";

	}

	@RequestMapping(value = "/clase", method = RequestMethod.PUT)
	public String updateClases(@Valid @RequestBody Clase p) {
		return "Clases";
	}

	@RequestMapping(value = "/clases", method = RequestMethod.POST)
	public String createClases(@Valid @RequestBody Clase p) {
		return "Clases";
	}

	// ----------Entrenador---------------------------------------//

	@RequestMapping(value = "/entrenadores", method = RequestMethod.GET)
	public String getEntrenadores() {
		return "Entrenadores";
	}

	@RequestMapping(value = "/entrenador/{id}", method = RequestMethod.GET)
	public String getEntrenador(@PathVariable String id) {
		return "Entrenador";
	}

	@RequestMapping(value = "/entrenador/{id}", method = RequestMethod.DELETE)
	public String deletEntrenador(@PathVariable String id) {
		return "Entrenador";

	}

	@RequestMapping(value = "/entrenador", method = RequestMethod.PUT)
	public String updateEntrenador(@Valid @RequestBody Entrenador p) {
		return "Entrenador";
	}

	@RequestMapping(value = "/entrenador", method = RequestMethod.POST)
	public String createEntrenador(@Valid @RequestBody Entrenador p) {
		return "Entrenador";
	}

	// ----------Movimiento de caja---------------------------------------//

	@RequestMapping(value = "/movimientos", method = RequestMethod.GET)
	public String getMoviminetos() {
		return "Movimientos";
	}

	@RequestMapping(value = "/movimiento/{id}", method = RequestMethod.GET)
	public String getMovimiento(@PathVariable String id) {
		return "movimiento";
	}

	@RequestMapping(value = "/movimiento/{id}", method = RequestMethod.DELETE)
	public String deletMovimiento(@PathVariable String id) {
		return "movimiento";

	}

	@RequestMapping(value = "/movimiento", method = RequestMethod.PUT)
	public String updateMovimiento(@Valid @RequestBody MovimientoCaja p) {
		return "movimiento";
	}

	@RequestMapping(value = "/movimiento", method = RequestMethod.POST)
	public String createMovimiento(@Valid @RequestBody MovimientoCaja p) {
		return "Movimiento";
	}

	// ----------Preguntas---------------------------------------//

	@RequestMapping(value = "/preguntas", method = RequestMethod.GET)
	public String getPreguntas() {
		return "preguntas";
	}

	@RequestMapping(value = "/pregunta/{id}", method = RequestMethod.GET)
	public String getPregunta(@PathVariable String id) {
		return "Pregunta";
	}

	@RequestMapping(value = "/pregunta/{id}", method = RequestMethod.DELETE)
	public String deletPregunta(@PathVariable String id) {
		return "Pregunta";

	}

	@RequestMapping(value = "/pregunta", method = RequestMethod.PUT)
	public String updatePregunta(@Valid @RequestBody Pregunta p) {
		return "Pregunta";
	}

	@RequestMapping(value = "/pregunta", method = RequestMethod.POST)
	public String createPregunta(@Valid @RequestBody Pregunta p) {
		return "Movimiento";
	}
	
	// ----------Progresos---------------------------------------//

	@RequestMapping(value = "/progresos/alumno/{id}", method = RequestMethod.GET)
	public String getProgresosAlumno(@PathVariable String idAlumno) {
		return "Progreso";
	}
	
	@RequestMapping(value = "/progreso/{id}", method = RequestMethod.GET)
	public String getProgreso(@PathVariable String idProgreso) {
		return "Progreso";
	}



	@RequestMapping(value = "/progreso", method = RequestMethod.DELETE)
	public String deletProgreso(@PathVariable String idProgreso) {
		return "Progreso";

	}

	@RequestMapping(value = "/progreso", method = RequestMethod.PUT)
	public String updateProgreso(@Valid @RequestBody Progreso p) {
		return "Progreso";
	}

	@RequestMapping(value = "/progreso/{id}", method = RequestMethod.POST)
	public String createProgreso(@Valid @RequestBody Progreso p,@PathVariable String idEstudiante) {
		return "Progreso";
	}
	
	
	// ----------subscripciones---------------------------------------//

	@RequestMapping(value = "/subscripciones/alumno/{id}", method = RequestMethod.GET)
	public String getSubscripcionesAlumno(@PathVariable String idAlumno) {
		return "subscripcion";
	}
	
	@RequestMapping(value = "/subscripciones", method = RequestMethod.GET)
	public String getSubscripciones() {
		return "subscripciones";
	}
	
	@RequestMapping(value = "/subscripcion/{id}", method = RequestMethod.GET)
	public String getSubscripcion(@PathVariable String idProgreso) {
		return "subscripcion";
	}



	@RequestMapping(value = "/subscripcion", method = RequestMethod.DELETE)
	public String deletSubscripcion(@PathVariable String idProgreso) {
		return "subscripcion";

	}

	@RequestMapping(value = "/subscripcion", method = RequestMethod.PUT)
	public String updateSubscripcion(@Valid @RequestBody Subscripcion p) {
		return "subscripcion";
	}

	@RequestMapping(value = "/subscripcion/{id}", method = RequestMethod.POST)
	public String createSubscripcion(@Valid @RequestBody Subscripcion p,@PathVariable String idEstudiante) {
		return "subscripcion";
	}
	
	
	
}