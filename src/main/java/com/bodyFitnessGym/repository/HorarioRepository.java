package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bodyFitnessGym.model.entity.Clase;
import com.bodyFitnessGym.model.entity.Horario;

public interface HorarioRepository extends CrudRepository<Horario, Long> {

	@Query(value = "SELECT * FROM horario h WHERE h.dia <= (:diaFinal) AND h.dia >= (:diaInicial)", nativeQuery = true)
	Collection<Clase> filterHorario(String diaInicial, String diaFinal);

}