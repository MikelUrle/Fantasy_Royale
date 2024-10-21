package com.urle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urle.repository.ContribucionRepository;
import com.urle.repository.JugadoresRepository;

import jakarta.transaction.Transactional;

// Zona servicios para estructurar el codigo y facilitar la resolucion de errores
@Service
public class Servicios {

	// Importamos los repositorios para conseguir los datos necesarios
    @Autowired
    private ContribucionRepository contribucionRepo;
    
	@Autowired
	private JugadoresRepository jugadorRepo;

	// Funcion para resetear los goles y las asistencias a los jugadores
    @Transactional
    public void resetAsistGol(int jugadorId) {
        contribucionRepo.resetAsistGolById(jugadorId);
    }
    
    // Funcion para actaulizar los puntos de un jugador
    public void actualizarPuntos(int jugadorId, int puntos) {
    	jugadorRepo.actualizarPuntosPorId(jugadorId, puntos);
    }
}
