package com.urle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.urle.model.Jugador;

import jakarta.transaction.Transactional;

@Repository
public interface JugadoresRepository extends JpaRepository<Jugador, Integer> {
	
	// Funcion para encontrar jugadores por su equipo
	List<Jugador> findByEquipoId(int equipoId);
	// Funcion para encontrar jugadores por su posicion
	List<Jugador> findByPosicionId(int posicionId);
	
	// Funcion para hacer un "Update" para en los jugadores con los puntos asignados
    @Modifying
    @Transactional
    @Query("UPDATE Jugador j SET j.puntos = :puntos WHERE j.id = :jugadorId")
    void actualizarPuntosPorId(@Param("jugadorId") int jugadorId, @Param("puntos") int puntos);
}

