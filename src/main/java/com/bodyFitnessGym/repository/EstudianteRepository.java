package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bodyFitnessGym.model.entity.Alumno;
import com.bodyFitnessGym.model.entity.Clase;

public interface EstudianteRepository extends CrudRepository<Alumno, Long> {
	
	@Query(value = "SELECT * FROM alumno a WHERE a.usuario_alumno = (:usuario) AND a.contrasenia = (:password)", nativeQuery = true)
	Collection<Alumno> authenticate(String usuario, String password);
}