package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bodyFitnessGym.model.entity.Alumno;
import com.bodyFitnessGym.model.entity.Clase;

public interface EstudianteRepository extends CrudRepository<Alumno, Long> {

	@Query(value = "set @type = 0;  set @num  = 1; @num := if(@type = id, @num + 1, 1) as row_number,\r\n" + 
			"   @type := type as dummySELECT * FROM ALUMNO", nativeQuery = true)
	Collection<Alumno> findAllAlumno();
}