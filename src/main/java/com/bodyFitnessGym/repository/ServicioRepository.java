package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bodyFitnessGym.model.entity.Servicio;

public interface ServicioRepository extends CrudRepository<Servicio, Long> {

	@Query(value = "SELECT * FROM Servicio s WHERE s.nombre_servicio = (:nombreServicio)", nativeQuery = true)
	Collection<Servicio> findAllServicesByName(String nombreServicio);
}