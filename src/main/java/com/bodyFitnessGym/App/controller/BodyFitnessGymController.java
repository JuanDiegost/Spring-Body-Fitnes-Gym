package com.bodyFitnessGym.App.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bodyFitnessGym.model.entity.Alumno;
import com.bodyFitnessGym.model.entity.Clase;
import com.bodyFitnessGym.model.entity.Entrenador;
import com.bodyFitnessGym.model.entity.ProgresoImagen;
import com.bodyFitnessGym.model.entity.MovimientoCaja;
import com.bodyFitnessGym.model.entity.Pregunta;
import com.bodyFitnessGym.model.entity.Progreso;
import com.bodyFitnessGym.model.entity.Servicio;
import com.bodyFitnessGym.model.entity.Subscripcion;
import com.bodyFitnessGym.persistence.JsonManager;
import com.bodyFitnessGym.repository.AdministradorRepository;
import com.bodyFitnessGym.repository.ClaseRepository;
import com.bodyFitnessGym.repository.EntrenadorRepository;
import com.bodyFitnessGym.repository.EstudianteRepository;
import com.bodyFitnessGym.repository.ImagenProgresoRepository;
import com.bodyFitnessGym.repository.MovimientoRepository;
import com.bodyFitnessGym.repository.PreguntaRepository;
import com.bodyFitnessGym.repository.ProgresoRepository;
import com.bodyFitnessGym.repository.ServicioRepository;
import com.bodyFitnessGym.repository.SubscripcionRepository;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
public class BodyFitnessGymController {

	@Autowired
	private EstudianteRepository estudianteRepository;
	@Autowired
	private AdministradorRepository administradorRepository;
	@Autowired
	private ClaseRepository claseRepository;
	@Autowired
	private EntrenadorRepository entrenadorRepository;
	@Autowired
	private MovimientoRepository movimientoRepository;
	@Autowired
	private PreguntaRepository preguntaRepository;
	@Autowired
	private ProgresoRepository progresoRepository;
	@Autowired
	private ImagenProgresoRepository progresoImagenRepository;
	@Autowired
	private ServicioRepository servicioRepository;
	@Autowired
	private SubscripcionRepository subscripcionRepository;

	// ----------Alumnos---------------------------------------//

	@RequestMapping(value = "/alumnos", method = RequestMethod.GET)
	public String getAlumnos() {
		Iterable<Alumno> list = estudianteRepository.findAll();
		int count = 1;
		for (Alumno alumno : list) {
			alumno.setPosition(count);
			count++;
		}
		return JsonManager.toJson(list);
	}

	@RequestMapping(value = "/alumno/{id}", method = RequestMethod.GET)
	public String getAlumno(@PathVariable Long id) {
		if (estudianteRepository.existsById(id))
			return JsonManager.toJson(estudianteRepository.findById(id));
		return "No se encontro al estudiante";
	}

	@RequestMapping(value = "/alumno/{id}", method = RequestMethod.DELETE)
	public String deletAlumno(@PathVariable Long id) {
		if (estudianteRepository.existsById(id)) {
			estudianteRepository.deleteById(id);
			return "Estudiante eliminado";
		}
		return "No se encontro al estudiante";
	}

	@RequestMapping(value = "/alumno", method = RequestMethod.PUT)
	public String updateAlumno(@Valid @RequestBody Alumno p) {
		estudianteRepository.save(p);
		return JsonManager.toJson(p);
	}

	@RequestMapping(value = "/alumno", method = RequestMethod.POST)
	public String createAlumno(@Valid @RequestBody Alumno p) {
		estudianteRepository.save(p);
		return "Guardado";
	}

	// ----------Servicios---------------------------------------//

	@RequestMapping(value = "/servicios", method = RequestMethod.GET)
	public String getServicios() {
		return JsonManager.toJson(servicioRepository.findAll());
	}

	@RequestMapping(value = "/servicio/{id}", method = RequestMethod.GET)
	public String getServicio(@PathVariable Long id) {
		return JsonManager.toJson(estudianteRepository.findById(id));
	}

	@RequestMapping(value = "/servicio/{id}", method = RequestMethod.DELETE)
	public String deletServicio(@PathVariable Long id) {
		servicioRepository.deleteById(id);
		return "Borrado";
	}

	@RequestMapping(value = "/servicio", method = RequestMethod.PUT)
	public String updateServicio(@Valid @RequestBody Servicio p) {
		return JsonManager.toJson(servicioRepository.save(p));
	}

	@RequestMapping(value = "/servicio", method = RequestMethod.POST)
	public String createServicio(@Valid @RequestBody Servicio p) {
		return JsonManager.toJson(servicioRepository.save(p));
	}

	// ----------Clases---------------------------------------//

	@RequestMapping(value = "/clases", method = RequestMethod.GET)
	public String getClases() {
		return JsonManager.toJson(claseRepository.findAll());
	}

	@RequestMapping(value = "/clase/{id}", method = RequestMethod.GET)
	public String getClases(@PathVariable Long id) {
		return JsonManager.toJson(claseRepository.findById(id));
	}

	@RequestMapping(value = "/clase/servicio/{id}", method = RequestMethod.GET)
	public String getClasesByIdServicio(@PathVariable Long id) {
		return JsonManager.toJson(claseRepository.findAllClaseByIdServicio(id));
	}

	@RequestMapping(value = "/clase/{id}", method = RequestMethod.DELETE)
	public String deletClases(@PathVariable Long id) {
		claseRepository.deleteById(id);
		return "Borrado";

	}

	@RequestMapping(value = "/clase", method = RequestMethod.PUT)
	public String updateClases(@Valid @RequestBody Clase p) {
		return JsonManager.toJson(claseRepository.save(p));
	}

	@RequestMapping(value = "/clase/servicio/{idServicio}/entrenador/{idEntrenador}", method = RequestMethod.POST)
	public String createClases(@Valid @RequestBody Clase p, @PathVariable("idServicio") Long idServicio, @PathVariable("idEntrenador") Long idEntrenador) {
		Servicio servicio = servicioRepository.findById(idServicio).get();
		Entrenador entrenador =entrenadorRepository.findById(idEntrenador).get();
		p.setServicio(servicio);
		p.setEntrendor(entrenador);
		return JsonManager.toJson(claseRepository.save(p));
	}

	// ----------Entrenador---------------------------------------//

	@RequestMapping(value = "/entrenadores", method = RequestMethod.GET)
	public String getEntrenadores() {
		return JsonManager.toJson(entrenadorRepository.findAll());
	}

	@RequestMapping(value = "/entrenador/{id}", method = RequestMethod.GET)
	public String getEntrenador(@PathVariable Long id) {
		return JsonManager.toJson(entrenadorRepository.findById(id));
	}

	@RequestMapping(value = "/entrenador/{id}", method = RequestMethod.DELETE)
	public String deletEntrenador(@PathVariable Long id) {
		entrenadorRepository.deleteById(id);
		return "Borrado";

	}

	@RequestMapping(value = "/entrenador", method = RequestMethod.PUT)
	public String updateEntrenador(@Valid @RequestBody Entrenador p) {
		return JsonManager.toJson(entrenadorRepository.save(p));
	}

	@RequestMapping(value = "/entrenador", method = RequestMethod.POST)
	public String createEntrenador(@Valid @RequestBody Entrenador p) {
		return JsonManager.toJson(entrenadorRepository.save(p));
	}

	// ----------Movimiento de caja---------------------------------------//

	@RequestMapping(value = "/movimientos", method = RequestMethod.GET)
	public String getMoviminetos() {
		return JsonManager.toJson(movimientoRepository.findAll());
	}

	@RequestMapping(value = "/movimiento/{id}", method = RequestMethod.GET)
	public String getMovimiento(@PathVariable Long id) {
		return JsonManager.toJson(movimientoRepository.findById(id));
	}

	@RequestMapping(value = "/movimiento/{id}", method = RequestMethod.DELETE)
	public String deletMovimiento(@PathVariable Long id) {
		movimientoRepository.deleteById(id);
		return "borrado";

	}

	@RequestMapping(value = "/movimiento", method = RequestMethod.PUT)
	public String updateMovimiento(@Valid @RequestBody MovimientoCaja p) {
		return JsonManager.toJson(movimientoRepository.save(p));
	}

	@RequestMapping(value = "/movimiento/{idSuscripcion}", method = RequestMethod.POST)
	public String createMovimiento(@Valid @RequestBody MovimientoCaja p,
			@Valid @PathVariable("idSuscripcion") Long idEstudiante) {

		return JsonManager.toJson(movimientoRepository.save(p));
	}

	@RequestMapping(value = "/movimiento", method = RequestMethod.POST)
	public String createMovimiento(@Valid @RequestBody MovimientoCaja p) {
		return JsonManager.toJson(movimientoRepository.save(p));
	}

	// ----------Preguntas---------------------------------------//

	@RequestMapping(value = "/preguntas", method = RequestMethod.GET)
	public String getPreguntas() {
		return JsonManager.toJson(preguntaRepository.findAll());
	}

	@RequestMapping(value = "/pregunta/{id}", method = RequestMethod.GET)
	public String getPregunta(@PathVariable Long id) {
		return JsonManager.toJson(preguntaRepository.findById(id));
	}

	@RequestMapping(value = "/pregunta/{id}", method = RequestMethod.DELETE)
	public String deletPregunta(@PathVariable Long id) {
		preguntaRepository.deleteById(id);
		return "borrado";

	}

	@RequestMapping(value = "/pregunta", method = RequestMethod.PUT)
	public String updatePregunta(@Valid @RequestBody Pregunta p) {
		return JsonManager.toJson(preguntaRepository.save(p));
	}

	@RequestMapping(value = "/pregunta", method = RequestMethod.POST)
	public String createPregunta(@Valid @RequestBody Pregunta p) {
		return JsonManager.toJson(preguntaRepository.save(p));
	}

	// ----------Progresos---------------------------------------//

	@RequestMapping(value = "/progresos/alumno/{id}", method = RequestMethod.GET)
	public String getProgresosAlumno(@PathVariable("id") Long idAlumno) {
		return JsonManager.toJson(estudianteRepository.findById(idAlumno).get().getHistorialProgreso());
	}

	@RequestMapping(value = "/progreso/{id}", method = RequestMethod.GET)
	public String getProgreso(@PathVariable("id") Long idProgreso) {
		return JsonManager.toJson(progresoRepository.findById(idProgreso).get());
	}

	@RequestMapping(value = "/progreso/{id}", method = RequestMethod.DELETE)
	public String deletProgreso(@PathVariable("id") Long idProgreso) {
		progresoRepository.deleteById(idProgreso);
		return "Borrado";

	}

	@RequestMapping(value = "/progreso", method = RequestMethod.PUT)
	public String updateProgreso(@Valid @RequestBody Progreso p) {
		return JsonManager.toJson(progresoRepository.save(p));
	}

	@RequestMapping(value = "/progreso/{id}", method = RequestMethod.POST)
	public String createProgreso(@Valid @PathVariable("id") Long idEstudiante, @Valid @RequestBody Progreso p) {
		p = progresoRepository.save(p);
		Alumno alumno = estudianteRepository.findById(idEstudiante).get();
		alumno.addProgreso(p);
		estudianteRepository.save(alumno);
		return JsonManager.toJson(p);
	}

	// ----------Progresos Imagen---------------------------------------//

	@RequestMapping(value = "/progresosImagen/alumno/{id}", method = RequestMethod.GET)
	public String getProgresosImagenAlumno(@PathVariable("id") Long idAlumno) {
		return JsonManager.toJson(estudianteRepository.findById(idAlumno).get().getHistorialProgresoImagen());
	}

	@RequestMapping(value = "/progresoImagen/{id}", method = RequestMethod.GET)
	public String getProgresoImagen(@PathVariable("id") Long idProgresoImagen) {
		return JsonManager.toJson(progresoImagenRepository.findById(idProgresoImagen).get());
	}

	@RequestMapping(value = "/progresoImagen/{id}", method = RequestMethod.DELETE)
	public String deletProgresoImagen(@PathVariable("id") Long idProgresoImagen) {
		progresoImagenRepository.deleteById(idProgresoImagen);
		return "Borrado";

	}

	@RequestMapping(value = "/progresoImagen", method = RequestMethod.PUT)
	public String updateProgresoImagen(@Valid @RequestBody ProgresoImagen p) {
		return JsonManager.toJson(progresoImagenRepository.save(p));
	}

	@RequestMapping(value = "/progresoImagen/{id}", method = RequestMethod.POST)
	public String createProgresoImagen(@Valid @PathVariable("id") Long idEstudiante,
			@Valid @RequestBody ProgresoImagen p) {
		System.out.println("ola");
		Alumno alumno = estudianteRepository.findById(idEstudiante).get();
		try {
			alumno.addProgresoImagen(p);
			p = progresoImagenRepository.save(p);
			estudianteRepository.save(alumno);
		} catch (UnirestException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return JsonManager.toJson(p);
	}

	// ----------subscripciones---------------------------------------//

	@RequestMapping(value = "/suscripciones/alumno/{id}", method = RequestMethod.GET)
	public String getSubscripcionesAlumno(@PathVariable("id") Long idAlumno) {
		return JsonManager.toJson(estudianteRepository.findById(idAlumno).get().getHistorialProgreso());
	}

	@RequestMapping(value = "/suscripciones", method = RequestMethod.GET)
	public String getSubscripciones() {
		return JsonManager.toJson(subscripcionRepository.findAll());
	}

	@RequestMapping(value = "/suscripcion/{id}", method = RequestMethod.GET)
	public String getSubscripcion(@PathVariable("id") Long id) {
		return JsonManager.toJson(subscripcionRepository.findById(id));
	}

	@RequestMapping(value = "/suscripcion/{id}", method = RequestMethod.DELETE)
	public String deletSubscripcion(@PathVariable("id") Long idProgreso) {
		progresoRepository.deleteById(idProgreso);
		return "Borrado";

	}

	@RequestMapping(value = "/suscripcion", method = RequestMethod.PUT)
	public String updateSubscripcion(@Valid @RequestBody Subscripcion p) {
		return JsonManager.toJson(subscripcionRepository.save(p));
	}

	@RequestMapping(value = "/suscripcion/alumno/{id}/servicio/{idServicio}", method = RequestMethod.POST)
	public String createSubscripcion(@Valid @RequestBody Subscripcion p, @PathVariable("id") Long idEstudiante,
			@PathVariable("idServicio") Long idServicio) {
		Servicio servicio = servicioRepository.findById(idServicio).get();
		p.setServicio(servicio);
		Subscripcion subscripcion = subscripcionRepository.save(p);
		Alumno alumno = estudianteRepository.findById(idEstudiante).get();
		alumno.addSubscripcion(subscripcion);
		estudianteRepository.save(alumno);
		return JsonManager.toJson(subscripcion);
	}

}