package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bodyFitnessGym.model.entity.Clase;

public interface ClaseRepository extends CrudRepository<Clase, Long> {

	@Query(value = "SELECT * FROM clase c WHERE c.servicio_id = ?1", nativeQuery = true)
	Collection<Clase> findAllClaseByIdServicio(Long status);
}