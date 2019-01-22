package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bodyFitnessGym.model.entity.Alumno;
import com.bodyFitnessGym.model.entity.Clase;

public interface EstudianteRepository extends CrudRepository<Alumno, Long> {

}