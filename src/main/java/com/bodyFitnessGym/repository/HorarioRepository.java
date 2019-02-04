package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bodyFitnessGym.model.entity.Clase;
import com.bodyFitnessGym.model.entity.Horario;

public interface HorarioRepository extends CrudRepository<Horario, Long> {

	@Query(value = "SELECT h.dia, h.hora_inicio, h.hora_fin, c.descripcion "
			+ "from horario h join clase_horario_clase ch on h.id_horario=ch.horario_clase_id_horario join clase c on c.id_clase=ch.clase_id_clase "
			+ "WHERE h.dia <= (:diaFinal) AND h.dia >= (:diaInicial)", nativeQuery = true)
	Collection<Object> filterHorario(String diaInicial, String diaFinal);

}