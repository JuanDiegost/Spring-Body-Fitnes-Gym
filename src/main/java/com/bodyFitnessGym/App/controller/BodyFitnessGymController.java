package com.bodyFitnessGym.App.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bodyFitnessGym.model.entity.Administrador;
import com.bodyFitnessGym.model.entity.Alumno;
import com.bodyFitnessGym.model.entity.Clase;
import com.bodyFitnessGym.model.entity.Elemento;
import com.bodyFitnessGym.model.entity.Entrenador;
import com.bodyFitnessGym.model.entity.ErrorSistema;
import com.bodyFitnessGym.model.entity.HistorialProgreso;
import com.bodyFitnessGym.model.entity.Horario;
import com.bodyFitnessGym.model.entity.ProgresoImagen;
import com.bodyFitnessGym.model.entity.MovimientoCaja;
import com.bodyFitnessGym.model.entity.Noticia;
import com.bodyFitnessGym.model.entity.Pregunta;
import com.bodyFitnessGym.model.entity.Progreso;
import com.bodyFitnessGym.model.entity.Servicio;
import com.bodyFitnessGym.model.entity.Subscripcion;
import com.bodyFitnessGym.persistence.JsonManager;
import com.bodyFitnessGym.reports.Reports;
import com.bodyFitnessGym.repository.AdministradorRepository;
import com.bodyFitnessGym.repository.ClaseRepository;
import com.bodyFitnessGym.repository.ElementoRepository;
import com.bodyFitnessGym.repository.EntrenadorRepository;
import com.bodyFitnessGym.repository.ErrorRepository;
import com.bodyFitnessGym.repository.EstudianteRepository;
import com.bodyFitnessGym.repository.HistorialProgresoRepository;
import com.bodyFitnessGym.repository.HorarioRepository;
import com.bodyFitnessGym.repository.ImagenProgresoRepository;
import com.bodyFitnessGym.repository.MovimientoRepository;
import com.bodyFitnessGym.repository.NoticiaRepository;
import com.bodyFitnessGym.repository.PreguntaRepository;
import com.bodyFitnessGym.repository.ProgresoRepository;
import com.bodyFitnessGym.repository.ServicioRepository;
import com.bodyFitnessGym.repository.SubscripcionRepository;
import com.mashape.unirest.http.exceptions.UnirestException;

import net.sf.jasperreports.engine.JRException;

@RestController
public class BodyFitnessGymController {

	@Autowired
	private EstudianteRepository estudianteRepository;
	@Autowired
	private AdministradorRepository administradorRepository;
	@Autowired
	private ClaseRepository claseRepository;
	@Autowired
	private HorarioRepository horarioRepository;
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
	@Autowired
	private NoticiaRepository noticiaRepository;
	@Autowired
	private ElementoRepository elementoRepository;
	@Autowired
	private HistorialProgresoRepository historialProgresoRepository;
	@Autowired
	private ErrorRepository errorRepository;
	// ------------logins---------------------------------------//

	@RequestMapping(value = "/login/{usuario}/{password}", method = RequestMethod.GET)
	public String login(@PathVariable("usuario") String usuario, @PathVariable("password") String password) {
		Collection<Administrador> admin = administradorRepository.authenticate(usuario, password);
		if (admin.size() > 0) {
			return JsonManager.toJson(admin);
		}
		Collection<Alumno> alumno = estudianteRepository.authenticate(usuario, password);
		if (alumno.size() > 0) {
			return JsonManager.toJson(alumno);
		}
		Collection<Entrenador> entrenador = entrenadorRepository.authenticate(usuario, password);
		if (entrenador.size() > 0) {
			return JsonManager.toJson(entrenador);
		}
		if (errorRepository.count() == 0) {
			addSystemErrors();
		}
		return JsonManager.toJson(errorRepository.findError(ErrorSistema.USUARIO_NO_EXISTE));
	}

	@RequestMapping(value = "/login/alumno/{usuario}/{password}", method = RequestMethod.GET)
	public String loginAlumno(@PathVariable("usuario") String usuario, @PathVariable("password") String password) {
		return JsonManager.toJson(estudianteRepository.authenticate(usuario, password));
	}

	@RequestMapping(value = "/login/admin/{usuario}/{password}", method = RequestMethod.GET)
	public String loginAdmin(@PathVariable("usuario") String usuario, @PathVariable("password") String password) {
		return JsonManager.toJson(administradorRepository.authenticate(usuario, password));
	}

	@RequestMapping(value = "/login/entrenador/{usuario}/{password}", method = RequestMethod.GET)
	public String loginEntrenador(@PathVariable("usuario") String usuario, @PathVariable("password") String password) {
		return JsonManager.toJson(entrenadorRepository.authenticate(usuario, password));
	}

	@RequestMapping(value = "/cambiarContrasenia/{usuario}/{oldPassword}/{newPassword}", method = RequestMethod.GET)
	public String changePassword(@PathVariable("usuario") String usuario,
			@PathVariable("oldPassword") String oldPassword, @PathVariable("newPassword") String newPassword) {
		Collection<Administrador> admin = administradorRepository.authenticate(usuario, oldPassword);
		if (admin.size() > 0) {
			for (Administrador administrador : admin) {
				administrador.setContrasena(newPassword);
				administradorRepository.save(administrador);
			}
			return JsonManager.toJson(admin);
		}
		Collection<Alumno> alumnos = estudianteRepository.authenticate(usuario, oldPassword);
		if (alumnos.size() > 0) {
			for (Alumno alumno : alumnos) {
				alumno.setContrasenia(newPassword);
				estudianteRepository.save(alumno);
			}
			return JsonManager.toJson(alumnos);
		}
		Collection<Entrenador> entrenadores = entrenadorRepository.authenticate(usuario, oldPassword);
		if (entrenadores.size() > 0) {
			for (Entrenador entrenador : entrenadores) {
				entrenador.setContraseniaEntrenador(newPassword);
				entrenadorRepository.save(entrenador);
			}
			return JsonManager.toJson(entrenadores);
		}
		return "Usuario no existe";
	}

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
		return JsonManager.toJson(estudianteRepository.save(p));
	}

	@RequestMapping(value = "/alumno", method = RequestMethod.POST)
	public String createAlumno(@Valid @RequestBody Alumno p) {
		if (estudianteRepository.findAllByName(p.getUsuarioAlumno()).size()==0) {
			if (p.validateAlumno()) {
				return JsonManager.toJson(estudianteRepository.save(p));
			}else {
				if (errorRepository.count() == 0) {
					addSystemErrors();
				}
				return JsonManager.toJson(errorRepository.findError(ErrorSistema.USUARIO_CON_EDAD_INVALIDA));
			}
		}else {
			if (errorRepository.count() == 0) {
				addSystemErrors();
			}
			return JsonManager.toJson(errorRepository.findError(ErrorSistema.USUARIO_EN_USO));
		}
	}

	@RequestMapping(value = "/alumnos", method = RequestMethod.PUT)
	public String updateAlumnos(@Valid @RequestBody List<Alumno> p) {
		estudianteRepository.deleteAll();
		for (Alumno alumno : p) {
			estudianteRepository.save(alumno);
		}
		return JsonManager.toJson(estudianteRepository.findAll());
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
		if (servicioRepository.findAllServicesByName(p.getNombreServicio()).size()==0) {
			return JsonManager.toJson(servicioRepository.save(p));
		}
		if (errorRepository.count() == 0) {
			addSystemErrors();
		}
		return JsonManager.toJson(errorRepository.findError(ErrorSistema.PROGRAMA_YA_EXISTE));
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
	public String createClases(@Valid @RequestBody Clase p, @PathVariable("idServicio") Long idServicio,
			@PathVariable("idEntrenador") Long idEntrenador) {
		Servicio servicio = servicioRepository.findById(idServicio).get();
		Entrenador entrenador = entrenadorRepository.findById(idEntrenador).get();
		p.setEntrendor(entrenador);
		p.setServicio(servicio);
		claseRepository.save(p);
		return JsonManager.toJson(p);
	}

	@RequestMapping(value = "/clase/{idClase}/getHorarios", method = RequestMethod.GET)
	public String getHorarioDeClase(@PathVariable("idClase") Long idClase) {
		Clase c = claseRepository.findById(idClase).get();
		return JsonManager.toJson(c.getHorarioClase());
	}

	// -----------Horario------------------------------------------//

	@RequestMapping(value = "/horarios", method = RequestMethod.GET)
	public String getHorarios() {
		return JsonManager.toJson(horarioRepository.findAll());
	}

	@RequestMapping(value = "/horario/filtro/{diaInicial}/{diaFinal}", method = RequestMethod.GET)
	public String getHorariosFiltrados(@PathVariable String diaInicial, @PathVariable String diaFinal) {
		return JsonManager.toJson(horarioRepository.filterHorario(diaInicial, diaFinal));
	}

	@RequestMapping(value = "/horario/filtroSinFechas", method = RequestMethod.GET)
	public String getHorariosFiltradosSinFechas() {
		return JsonManager.toJson(horarioRepository.filterHorarioSinFechas());
	}

	@RequestMapping(value = "/horario/{id}", method = RequestMethod.GET)
	public String getHorarios(@PathVariable Long id) {
		return JsonManager.toJson(horarioRepository.findById(id));
	}

	@RequestMapping(value = "/horario/servicio/{id}", method = RequestMethod.GET)
	public String getHorarioByIdServicio(@PathVariable Long id) {
		// return JsonManager.toJson(horarioRepository.findAllClaseByIdServicio(id));
		return "method ToDo";
	}

	@RequestMapping(value = "/horario/{id}", method = RequestMethod.DELETE)
	public String deletHorario(@PathVariable Long id) {
		horarioRepository.deleteById(id);
		return "Borrado";

	}

	@RequestMapping(value = "/horario", method = RequestMethod.PUT)
	public String updateHorario(@Valid @RequestBody Horario p) {
		return JsonManager.toJson(horarioRepository.save(p));
	}

	@RequestMapping(value = "/horario/clase/{idClase}", method = RequestMethod.POST)
	public String createHorario(@Valid @RequestBody Horario p, @PathVariable("idClase") Long idClase) {
		Clase clase = claseRepository.findById(idClase).get();
		horarioRepository.save(p);
		clase.addHorario(p);
		claseRepository.save(clase);
		return JsonManager.toJson(p);
	}

	@RequestMapping(value = "/horario/suscribirAlumnos/{idHorario}", method = RequestMethod.PUT)
	public String subscribirAlumnosAHorario(@Valid @RequestBody List<Alumno> p,
			@PathVariable("idHorario") Long idHorario) {
		Horario h = horarioRepository.findById(idHorario).get();
		h.setAsistencia(p);
		return JsonManager.toJson(horarioRepository.save(h));
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

	@RequestMapping(value = "/entrenador/{idEntrenador}/servicio/{idServicio}", method = RequestMethod.GET)
	public String agregarServicioEntrenador(@PathVariable("idEntrenador") Long idEntrenador,
			@PathVariable("idServicio") Long idServicio) {
		Entrenador entrenador = entrenadorRepository.findById(idEntrenador).get();
		Servicio servicio = servicioRepository.findById(idServicio).get();
		entrenador.addServicio(servicio);
		entrenadorRepository.save(entrenador);
		return JsonManager.toJson(entrenador);
	}
	// ----------Movimiento de caja---------------------------------------//

	@RequestMapping(value = "/movimientos", method = RequestMethod.GET)
	public String getMoviminetos() {
		return JsonManager.toJson(movimientoRepository.findAll());
	}

	@RequestMapping(value = "/movimientos/{filtro}/{fechaInicio}/{fechaFinal}", method = RequestMethod.GET)
	public String getMoviminetosFiltrados(@PathVariable("filtro") String filtro,
			@PathVariable("fechaInicio") String fechaInicio, @PathVariable("fechaFinal") String fechaFinal) {
		if (filtro.toLowerCase().equals("todos")) {
			return JsonManager.toJson(movimientoRepository.findAll(fechaInicio, fechaFinal));
		}
		return JsonManager.toJson(movimientoRepository.findAllFiltered(filtro, fechaInicio, fechaFinal));
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

	@RequestMapping(value = "/progresos", method = RequestMethod.GET)
	public String getProgresos() {
		return JsonManager.toJson(progresoRepository.findAll());
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

	@RequestMapping(value = "/progreso", method = RequestMethod.POST)
	public String createProgreso(@Valid @RequestBody Progreso p) {
		return JsonManager.toJson(progresoRepository.save(p));
	}

	// ---------------------------historial progresos--------------------//

	@RequestMapping(value = "/historialProgresos", method = RequestMethod.GET)
	public String getHistorialProgresos() {
		return JsonManager.toJson(historialProgresoRepository.findAll());
	}

	@RequestMapping(value = "/historialProgresos/{id}", method = RequestMethod.GET)
	public String getHistorialProgreso(@PathVariable("id") Long idHistorialProgreso) {
		return JsonManager.toJson(historialProgresoRepository.findById(idHistorialProgreso).get());
	}

	@RequestMapping(value = "/historialProgresos/alumno/{idAlumno}", method = RequestMethod.GET)
	public String getHistorialProgresoAlumno(@PathVariable("idAlumno") Long idAlumno) {
		return JsonManager.toJson("editar metodo " + historialProgresoRepository.findById(idAlumno).get());// editar
																											// metodo
	}

	@RequestMapping(value = "/historialProgresos/{id}", method = RequestMethod.DELETE)
	public String deletHistorialProgreso(@PathVariable("id") Long idHistorialProgreso) {
		historialProgresoRepository.deleteById(idHistorialProgreso);
		return "Borrado";
	}

	@RequestMapping(value = "/historialProgresos", method = RequestMethod.PUT)
	public String updateProgreso(@Valid @RequestBody HistorialProgreso p) {
		return JsonManager.toJson(historialProgresoRepository.save(p));
	}

	@RequestMapping(value = "/historialProgresos", method = RequestMethod.POST)
	public String createHistorialProgreso(@Valid @RequestBody HistorialProgreso p) {
		return JsonManager.toJson(historialProgresoRepository.save(p));
	}

	// ----------Progresos Imagen---------------------------------------//

	@RequestMapping(value = "/progresosImagen", method = RequestMethod.GET)
	public String getProgresosImagen() {
		return JsonManager.toJson(progresoImagenRepository.findAll());
	}

	@RequestMapping(value = "/progresosImagen/alumno/{id}", method = RequestMethod.GET)
	public String getProgresosImagenAlumno(@PathVariable("id") Long idAlumno) {// sort por fecha
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

	@RequestMapping(value = "/alumno/{id}/reporte.pdf", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> generarProgresos(@PathVariable Long id) {
		byte[] array;
		try {
			array = Reports.generarProgresosPDF(estudianteRepository.findById(id).get());
			ByteArrayResource resource = new ByteArrayResource(array);
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=reporte.pdf")
					.contentType(MediaType.APPLICATION_PDF) //
					.contentLength(array.length) //
					.body(resource);

		} catch (ParseException | ClassNotFoundException | IOException | JRException e) {
			e.printStackTrace();
			return null;
		}
	}

	// ----------subscripciones---------------------------------------//

	@RequestMapping(value = "/suscripciones/alumno/{id}", method = RequestMethod.GET)
	public String getSubscripcionesAlumno(@PathVariable("id") Long idAlumno) {
		return JsonManager.toJson(/* estudianteRepository.findById(idAlumno).get().getHistorialProgreso() */"sd");
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
	public String deletSubscripcion(@PathVariable("id") Long idSubscription) {
		subscripcionRepository.deleteById(idSubscription);
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
		movimientoRepository.save(p.getMovimientoDeCaja());
		Subscripcion subscripcion = subscripcionRepository.save(p);
		Alumno alumno = estudianteRepository.findById(idEstudiante).get();
		alumno.addSubscripcion(subscripcion);
		estudianteRepository.save(alumno);
		return JsonManager.toJson(subscripcion);
	}

	// ----------noticias---------------------------------------//

	@RequestMapping(value = "/noticias", method = RequestMethod.GET)
	public String getNoticias() {
		return JsonManager.toJson(noticiaRepository.findAll());
	}

	@RequestMapping(value = "/noticia/{id}", method = RequestMethod.GET)
	public String getNoticia(@PathVariable Long id) {
		return JsonManager.toJson(noticiaRepository.findById(id));
	}

	@RequestMapping(value = "/noticia/{id}", method = RequestMethod.DELETE)
	public String deleteNoticia(@PathVariable Long id) {
		noticiaRepository.deleteById(id);
		return "borrado";

	}

	@RequestMapping(value = "/noticia", method = RequestMethod.PUT)
	public String updateNoticia(@Valid @RequestBody Noticia p) {
		return JsonManager.toJson(noticiaRepository.save(p));
	}

	@RequestMapping(value = "/noticia", method = RequestMethod.POST)
	public String createNoticia(@Valid @RequestBody Noticia p) {
		if (noticiaRepository.finNoticiaByName(p.getTitular()).size()==0) {
			return JsonManager.toJson(noticiaRepository.save(p));
		}
		if (errorRepository.count() == 0) {
			addSystemErrors();
		}
		return JsonManager.toJson(errorRepository.findError(ErrorSistema.NOTICIA_YA_EXISTE));
	}

	// ----------Elementos---------------------------------------//

	@RequestMapping(value = "/elementos", method = RequestMethod.GET)
	public String getElementos() {
		return JsonManager.toJson(elementoRepository.findAll());
	}

	@RequestMapping(value = "/elemento/{id}", method = RequestMethod.GET)
	public String getElemento(@PathVariable Long id) {
		return JsonManager.toJson(elementoRepository.findById(id));
	}

	@RequestMapping(value = "/elemento/{id}", method = RequestMethod.DELETE)
	public String deleteElemento(@PathVariable Long id) {
		elementoRepository.deleteById(id);
		return "borrado";

	}

	@RequestMapping(value = "/elemento", method = RequestMethod.PUT)
	public String updateElemento(@Valid @RequestBody Elemento p) {
		return JsonManager.toJson(elementoRepository.save(p));
	}

	@RequestMapping(value = "/elemento", method = RequestMethod.POST)
	public String createElemento(@Valid @RequestBody Elemento p) {
		return JsonManager.toJson(elementoRepository.save(p));
	}

	// ---------------------ERRORES-------------------------------//
	@RequestMapping(value = "/addErrors", method = RequestMethod.GET)
	public void addSystemErrors() {
		if (errorRepository.count() == 0) {
			errorRepository.save(new ErrorSistema(ErrorSistema.USUARIO_NO_EXISTE));
			errorRepository.save(new ErrorSistema(ErrorSistema.PROGRAMA_YA_EXISTE));
			errorRepository.save(new ErrorSistema(ErrorSistema.NOTICIA_YA_EXISTE));
			errorRepository.save(new ErrorSistema(ErrorSistema.HORARIO_CRUZADO));
			errorRepository.save(new ErrorSistema(ErrorSistema.USUARIO_EN_USO));
		}
	}

	@RequestMapping(value = "/errores", method = RequestMethod.GET)
	public String getErrores() {
		return JsonManager.toJson(errorRepository.findAll());
	}
	
}