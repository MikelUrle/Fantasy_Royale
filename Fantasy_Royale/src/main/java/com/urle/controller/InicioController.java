package com.urle.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.urle.model.Jugador;
import com.urle.model.PosicionEnEL11;
import com.urle.repository.EquipoRepository;
import com.urle.repository.JornadaRepository;
import com.urle.repository.JugadoresRepository;
import com.urle.repository.PosicionEnEl11Repository;
import com.urle.repository.PosicionRepository;
import com.urle.repository.PuntuacionRepository;

// Controlador para iniciar el proyecto con la primera solicitud
@Controller
public class InicioController {
	
	// Importamos las repos para recoger los datos necesarios para el inicio
	@Autowired
	private EquipoRepository equiposRepo;
	
	@Autowired
	private JornadaRepository jornadaRepo;
	
	@Autowired
	private PosicionEnEl11Repository posicionEnEl11Repo;
	
	@Autowired
	private PosicionRepository posicionRepo;
	
	@Autowired
	private JugadoresRepository jugadorRepo;
	
	@Autowired
	private JugadoresRepository jugadoresRepo;
	
	@Autowired
	private PuntuacionRepository puntuacionRepo;
	
	@Autowired
	private PosicionEnEl11Repository posicion11Repo;
	
	// Solicitud inicial
	@RequestMapping("/")
	public String paginaPrincipal(Model model) {
		// Añadimos los atributos al modelo con las listas con los datos necesarios
		model.addAttribute("atr_lista_jugadores", jugadoresRepo.findAll());
		model.addAttribute("atr_lista_puntuacion", puntuacionRepo.findAll());
		model.addAttribute("atr_lista_posiciones11", posicion11Repo.findAll());
		model.addAttribute("atr_lista_equipos", equiposRepo.findAll());
		model.addAttribute("atr_lista_posiciones", posicionRepo.findAll());
		
		// Inicializamos el objeto
		Optional<PosicionEnEL11> posi11InfoFront= Optional.of(new PosicionEnEL11());
		
		// Parte para validar front
		
		int DelanteroNumero = 0;
		int MediocentroNumero = 0;
		int DefensaNumero = 0;
		int PorteroNumero = 0;
		
		
		for (int i = 1; i < 4; i++) {
			
			posi11InfoFront = posicionEnEl11Repo.findById(i);
			
			if (posi11InfoFront.get().getJugador().getId() != 0) {
				
				DelanteroNumero++;
			}
			
		}
		
		for (int i = 4; i < 7; i++) {
			
			posi11InfoFront = posicionEnEl11Repo.findById(i);
			
			if (posi11InfoFront.get().getJugador().getId() != 0) {
				
				MediocentroNumero++;
			}
			
		}
		
		for (int i = 7; i < 11; i++) {
			
			posi11InfoFront = posicionEnEl11Repo.findById(i);
			
			if (posi11InfoFront.get().getJugador().getId() != 0) {
				
				DefensaNumero++;
			}
			
		}
		
		for (int i = 11; i < 12; i++) {
			
			posi11InfoFront = posicionEnEl11Repo.findById(i);
			
			if (posi11InfoFront.get().getJugador().getId() != 0) {
				
				PorteroNumero++;
			}
			
		}
		
		// Atributos para validar en el front
		model.addAttribute("delanteroNumero", DelanteroNumero);
		model.addAttribute("mediocentroNumero", MediocentroNumero);
		model.addAttribute("defensaNumero", DefensaNumero);
		model.addAttribute("porteroNumero", PorteroNumero);
		
		// Filtrar para que no se puede añadir dos veces el mismo jugador
		List<PosicionEnEL11> listaJugadoresEnEl11 = posicionEnEl11Repo.findAll();
		
		int Variable1, Variable2, Variable3, Variable4, Variable5, Variable6, Variable7, Variable8, Variable9, Variable10, Variable11;
		
		Variable1 = listaJugadoresEnEl11.get(0).getJugador().getId();
		Variable2 = listaJugadoresEnEl11.get(1).getJugador().getId();
		Variable3 = listaJugadoresEnEl11.get(2).getJugador().getId();
		Variable4 = listaJugadoresEnEl11.get(3).getJugador().getId();
		Variable5 = listaJugadoresEnEl11.get(4).getJugador().getId();
		Variable6 = listaJugadoresEnEl11.get(5).getJugador().getId();
		Variable7 = listaJugadoresEnEl11.get(6).getJugador().getId();
		Variable8 = listaJugadoresEnEl11.get(7).getJugador().getId();
		Variable9 = listaJugadoresEnEl11.get(8).getJugador().getId();
		Variable10 = listaJugadoresEnEl11.get(9).getJugador().getId();
		Variable11 = listaJugadoresEnEl11.get(10).getJugador().getId();
		
		List<Integer> listaVariables = Arrays.asList(Variable1, Variable2, Variable3, Variable4, Variable5, 
                Variable6, Variable7, Variable8, Variable9, 
                Variable10, Variable11);
		
		model.addAttribute("listaVariables", listaVariables);
		
		// Devolvemos la vista
		return "index";
	}
	
}
