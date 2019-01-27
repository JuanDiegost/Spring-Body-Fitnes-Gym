package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bodyFitnessGym.model.entity.MovimientoCaja;

public interface MovimientoRepository extends CrudRepository<MovimientoCaja, Long>{

	@Query(value = "SELECT * FROM movimiento_caja m WHERE m.tipo = (:filtro) AND m.fecha_movimiento >= (:fechaInicial) AND m.fecha_movimiento <= (:fechaFinal)", nativeQuery = true)
	Collection<MovimientoCaja> findAllFiltered(String filtro, String fechaInicial, String fechaFinal);

	@Query(value = "SELECT * FROM movimiento_caja m WHERE m.fecha_movimiento >= (:fechaInicial) AND m.fecha_movimiento <= (:fechaFinal)", nativeQuery = true)
	Collection<MovimientoCaja> findAll(String fechaInicial, String fechaFinal);

	
}