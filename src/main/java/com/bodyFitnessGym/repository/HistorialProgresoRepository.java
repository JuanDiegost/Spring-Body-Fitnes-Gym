package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bodyFitnessGym.model.entity.HistorialProgreso;

public interface HistorialProgresoRepository extends CrudRepository<HistorialProgreso, Long>{

	
	@Query(value = "SELECT * FROM historial_progreso h WHERE h.alumno_dni_alumno = (:idAlumno)", nativeQuery = true)
	Collection<HistorialProgreso> findProgresosPorAlumno(Long idAlumno);

}