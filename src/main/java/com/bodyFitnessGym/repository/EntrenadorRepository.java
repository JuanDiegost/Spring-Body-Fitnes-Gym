package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bodyFitnessGym.model.entity.Entrenador;

public interface EntrenadorRepository extends CrudRepository<Entrenador, Long>{

	@Query(value = "SELECT * FROM entrenador e WHERE e.usuario_entrenador = (:usuario) AND e.contrasenia_entrenador = (:password)", nativeQuery = true)
	Collection<Entrenador> authenticate(String usuario, String password);
}
