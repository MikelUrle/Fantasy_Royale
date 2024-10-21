package com.urle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.urle.model.Contribucion;

@Repository
public interface ContribucionRepository extends JpaRepository<Contribucion, Integer> {
	
	// Funcion para recoger los datos de las contribuciones tomando en cuenta la id
	List<Contribucion> findById(int jugadorId);
	
	// Funcion para asignar a 0 los goles y las asistencias de un jugador
	@Modifying
	@Query("UPDATE Contribucion c SET c.asist = 0, c.gol = 0 WHERE c.id = :jugadorId")
	void resetAsistGolById(@Param("jugadorId") int jugadorId);
	
	// Funciones para ordenar por "Desc" y por "Asc" los goles
	List<Contribucion> findAllByOrderByGolDesc();
	List<Contribucion> findAllByOrderByGolAsc();
	
	// Funcion para ordenar por "Desc" y por "Asc" las asistencias
	List<Contribucion> findAllByOrderByAsistDesc();
	List<Contribucion> findAllByOrderByAsistAsc();
}

