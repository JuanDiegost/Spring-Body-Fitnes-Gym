package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bodyFitnessGym.model.entity.Clase;
import com.bodyFitnessGym.model.entity.Horario;

public interface HorarioRepository extends CrudRepository<Horario, Long> {

	@Query(value = "SELECT h.dia, h.hora_inicio, h.hora_fin, c.descripcion, s.nombre_servicio from "
			+ "horario h join clase_horario_clase ch on h.id_pregunta=ch.horario_clase_id_pregunta "
			+ "join clase c on c.id_clase=ch.clase_id_clase join servicio s on c.servicio_id_servicio=s.id_servicio "
			+ "WHERE h.dia <= (:diaFinal) AND h.dia >= (:diaInicial)", nativeQuery = true)
	Collection<Object> filterHorario(String diaInicial, String diaFinal);

}