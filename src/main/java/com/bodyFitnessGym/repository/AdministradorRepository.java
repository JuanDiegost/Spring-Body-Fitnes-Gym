package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bodyFitnessGym.model.entity.Administrador;

public interface AdministradorRepository extends CrudRepository<Administrador, Long>{

	@Query(value = "SELECT * FROM administrador a WHERE a.usuario = (:usuario) AND a.contrasena = (:password)", nativeQuery = true)
	Collection<Administrador> authenticate(String usuario, String password);
	
}
