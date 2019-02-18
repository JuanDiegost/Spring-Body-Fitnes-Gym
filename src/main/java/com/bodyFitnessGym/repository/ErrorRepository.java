package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bodyFitnessGym.model.entity.ErrorSistema;

public interface ErrorRepository extends CrudRepository<com.bodyFitnessGym.model.entity.ErrorSistema, Long>{
	
	@Query(value = "SELECT * FROM error_sistema e WHERE e.descripcion_error = (:error)", nativeQuery = true)
	Collection<ErrorSistema> findError(String error);

}