package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bodyFitnessGym.model.entity.MovimientoCaja;

public interface MovimientoRepository extends CrudRepository<MovimientoCaja, Long>{

	@Query(value = "SELECT * FROM movimiento_caja m WHERE m.tipo = 'ingreso'", nativeQuery = true)
	Collection<MovimientoCaja> findAllingresos();
	
	@Query(value = "SELECT * FROM movimiento_caja m WHERE m.tipo = 'egreso'", nativeQuery = true)
	Collection<MovimientoCaja> findAllegresos();

}