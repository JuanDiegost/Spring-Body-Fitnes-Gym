package com.bodyFitnessGym.repository;

import org.springframework.data.repository.CrudRepository;

import com.bodyFitnessGym.model.entity.Alumno;

public interface EstudianteRepository extends CrudRepository<Alumno, Long>{

}