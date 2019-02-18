package com.bodyFitnessGym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bodyFitnessGym.model.entity.Noticia;

public interface NoticiaRepository extends CrudRepository<Noticia, Long>{

	@Query(value = "SELECT * FROM NOTICIA n WHERE n.titular = (:titular)", nativeQuery = true)
	Collection<Noticia> finNoticiaByName(String titular);

}
