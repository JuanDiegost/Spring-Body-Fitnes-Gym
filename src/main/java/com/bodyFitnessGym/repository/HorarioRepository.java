package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bodyFitnessGym.model.entity.Clase;
import com.bodyFitnessGym.model.entity.Horario;

public interface HorarioRepository extends CrudRepository<Horario, Long> {

	@Query(value = "SELECT * FROM CLASE c WHERE c.servicio_id = ?1", nativeQuery = true)
	Collection<Clase> findAllClaseByIdServicio(Long status);
}