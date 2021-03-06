package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bodyFitnessGym.model.entity.Horario;

public interface HorarioRepository extends CrudRepository<Horario, Long> {

	@Query(value = "SELECT h.hora_inicio, h.hora_fin, c.descripcion, s.nombre_servicio, e.nombre_entrenador from "
			+ "horario h join clase_horario_clase ch on h.id_horario=ch.horario_clase_id_horario "
			+ "join clase c on c.id_clase=ch.clase_id_clase join servicio s on c.servicio_id_servicio=s.id_servicio "
			+ "join entrenador e on c.entrendor_dni_entrenador=e.dni_entrenador "
			+ "WHERE h.dia <= (:diaFinal) AND h.dia >= (:diaInicial)", nativeQuery = true)
	Collection<Object> filterHorario(String diaInicial, String diaFinal);

	@Query(value = "SELECT h.id_horario, h.hora_inicio, h.hora_fin, c.descripcion, s.nombre_servicio, e.nombre_entrenador from "
			+ "horario h join clase_horario_clase ch on h.id_horario=ch.horario_clase_id_horario "
			+ "join clase c on c.id_clase=ch.clase_id_clase join servicio s on c.servicio_id_servicio=s.id_servicio "
			+ "join entrenador e on c.entrendor_dni_entrenador=e.dni_entrenador", nativeQuery = true)
	Collection<Object> filterHorarioSinFechas();
	
	@Query(value = "SELECT h.id_horario, h.hora_inicio, h.hora_fin, c.descripcion, s.nombre_servicio, e.nombre_entrenador from "
			+ "horario h join clase_horario_clase ch on h.id_horario=ch.horario_clase_id_horario "
			+ "join clase c on c.id_clase=ch.clase_id_clase join servicio s on c.servicio_id_servicio=s.id_servicio "
			+ "join entrenador e on c.entrendor_dni_entrenador=e.dni_entrenador "
			+ "WHERE e.dni_entrenador = (:dniEntrenador)", nativeQuery = true)
	Collection<Object> filterHorarioSinFechasPorEntrenador(Long dniEntrenador);
	
	@Query(value = "SELECT h.hora_inicio, hora_fin, s.nombre_servicio FROM "
			+ "horario h join clase_horario_clase hc on (hc.horario_clase_id_horario=h.id_horario) "
			+ "join clase c on (hc.clase_id_clase=c.id_clase) "
			+ "join servicio_clases sc on(sc.clases_id_clase= c.id_clase) "
			+ "join servicio s on (sc.servicio_id_servicio=s.id_servicio)"
			+ "WHERE h.hora_inicio <= (:hora_inicio) AND h.hora_fin >= (:hora_inicio) "
			+ "AND s.nombre_servicio = (:nombreServicio)", nativeQuery = true)
	Collection<Object> getHorarioALaMismaHora(String nombreServicio, String hora_inicio);
	
	@Query(value = "SELECT c.numero_cupos FROM "
			+ "horario h join clase_horario_clase hc on (hc.horario_clase_id_horario=h.id_horario) "
			+ "join clase c on (hc.clase_id_clase=c.id_clase) "
			+ "WHERE h.id_horario=(:idHorario)", nativeQuery = true)
	Collection<Integer> getCuposHorario(Long idHorario);
	
	
}
