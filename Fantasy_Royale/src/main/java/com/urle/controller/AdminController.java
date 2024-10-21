package com.urle.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.antlr.v4.runtime.ParserInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.urle.model.Equipo;
import com.urle.model.Jornada;
import com.urle.model.Jugador;
import com.urle.model.Posicion;
import com.urle.model.PosicionEnEL11;
import com.urle.model.Contribucion;
import com.urle.repository.ContribucionRepository;
import com.urle.repository.EquipoRepository;
import com.urle.repository.JornadaRepository;
import com.urle.repository.JugadoresRepository;
import com.urle.repository.PosicionEnEl11Repository;
import com.urle.repository.PosicionRepository;
import com.urle.repository.PuntuacionRepository;
import com.urle.service.Servicios;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	// Añadimos las repos para poder usar las funciones
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
	private PuntuacionRepository puntuacionRepo;
	
	@Autowired
	private ContribucionRepository contribucionRepo;
	
    @Autowired
    private Servicios servicios;
	
    // Para cuando se quiera ir a ver la jornada con los partidos
	@RequestMapping("/jornada")
	public String jornada(Model model) {

		// Guardamos los datos en los atributos del modelo
		model.addAttribute("atr_lista_jornada", jornadaRepo.findAll());
		model.addAttribute("atr_lista_equipos", equiposRepo.findAll());
		
		// Devolvemos la vista 
		return "jornada";
	}
	
	// Para poder ver el campo con los jugadores en el 11
	@RequestMapping("/campo")
	public String campo(Model model) {
		model.addAttribute("atr_lista_jugadores", jugadorRepo.findAll());
		model.addAttribute("atr_lista_puntuacion", puntuacionRepo.findAll());
		model.addAttribute("atr_lista_posiciones11", posicionEnEl11Repo.findAll());
		
		// Recogemos la lista del 11 para hacer un sumatorio de los puntos de los jugadores que tenemos en el 11
		List<PosicionEnEL11> posi11Lista = posicionEnEl11Repo.findAll();
		int puntuacionTotal = 0;
		
		for (PosicionEnEL11 posi11 : posi11Lista) {
		
		puntuacionTotal = puntuacionTotal + posi11.getJugador().getPuntos();
				
		}
		
		// Los pasamos al front como atributo del modelo
		model.addAttribute("puntosTotal", puntuacionTotal);
		
		// Devolvemos la vista
		return "campoConJugadores";
	}
	
	// La llamada para poder crear una jornada aleatoria entre los distintos equipos de la liga
	@RequestMapping("/prepJornada")
	public String prepJornada(Model model) {

		List<Equipo> equipos = equiposRepo.findAll();
		// Quitamos el equipo "default" creado para el jugador "default" de la lista
		equipos.removeIf(equipo -> equipo.getId() == 0);
		
		// Colocar de manera aleatoria los elementos de la lista
		Collections.shuffle(equipos);
		
		int idVariable = 1;
		
		for (int i = 1; i < 21; i = i+2) {
			
	        Jornada jornadaActualizado = new Jornada();
	        
	        jornadaActualizado.setId(idVariable);
	        jornadaActualizado.setEquipoCasa(equipos.get((i-1)).getNombre());
	        jornadaActualizado.setEquipoVisitante(equipos.get(i).getNombre());
	        jornadaActualizado.setIdequipoCasa((int)equipos.get((i-1)).getId());
	        jornadaActualizado.setIdequipoVisitante((int)equipos.get(i).getId()); 

	        idVariable = idVariable + 1;
	        
	        jornadaRepo.save(jornadaActualizado);
			
		}
		
		// Enseñamos los datos conseguidos en el front pasandolos como atributos del modelo
		model.addAttribute("atr_lista_jornada", jornadaRepo.findAll());
		model.addAttribute("atr_lista_equipos", equiposRepo.findAll());
		
		// Devolvemos la vista
		return "jornada";
	}
	
	// En esta solicitud hacemos que se randomicen los resultados de la jornada y damos goles a cada lado
	@RequestMapping("/resultadosJornada")
	public String resultadosJornada(Model model) {
        
		List<Jornada> listajornada = jornadaRepo.findAll();
		
		// Inicializamos "Random" para poder utilizarlo
        Random random = new Random();

        int idVariable = 1;
        
		for (int i = 0; i < 10; i++) {
			
			// Generamos un numero random del 1 al 10 que seran los goles en general del partido
	        int numeroRandom = random.nextInt(10) + 1;
			
	        // Generamos los goles de modo random para el equipo de casa y se los resto al de los goles en general del partido
	        int golesCasa = random.nextInt(numeroRandom);
	        int golesFuera = (numeroRandom - golesCasa);
	        
	        Jornada jornadaActualizado = new Jornada();
	        
	        jornadaActualizado.setId(idVariable);
	        
	        jornadaActualizado.setEquipoCasa(listajornada.get((i)).getEquipoCasa());
	        jornadaActualizado.setEquipoVisitante(listajornada.get(i).getEquipoVisitante());
	        jornadaActualizado.setIdequipoCasa((int)listajornada.get((i)).getIdequipoCasa());
	        jornadaActualizado.setIdequipoVisitante((int)listajornada.get(i).getIdequipoVisitante()); 
	        
	        jornadaActualizado.setEquipoCasaMarcador(golesCasa);
	        jornadaActualizado.setEquipoVisitanteMarcador(golesFuera);
	        
	        idVariable = idVariable + 1;
	        
	        jornadaRepo.save(jornadaActualizado);
			
		}
		
		model.addAttribute("atr_lista_jornada", jornadaRepo.findAll());
		model.addAttribute("atr_lista_equipos", equiposRepo.findAll());
		
		// Llamamos a las distintas funciones para reiniciar los marcadores de goles y asistencias de los jugadores, para despues asignar los goles y por ultimo calcular los puntos
		reiniciarMarcadores();
		asignarGolesAsist();
		calcularPuntos();
		
		// Devolvemos la vista
		return "jornada";
	}
	
	// Solicitud para agregar al 11 el jugador
	@RequestMapping("/agregarAl11Jugador")

	public String agregarAl11Jugador(@RequestParam("jugadorId") Jugador jugadorId, Model model) {

		// Metemos los datos necesarios a los atributos del modelo para que las demas funcionalidades tengas los datos que necesitan
		model.addAttribute("atr_lista_posiciones11", posicionEnEl11Repo.findAll());
		model.addAttribute("atr_lista_puntuacion", puntuacionRepo.findAll());
		model.addAttribute("atr_lista_jugadores", jugadorRepo.findAll());
		model.addAttribute("atr_lista_jornada", jornadaRepo.findAll());
		model.addAttribute("atr_lista_equipos", equiposRepo.findAll());
		model.addAttribute("atr_lista_posiciones", posicionRepo.findAll());

		// Inicializamos los objetos
		Optional<PosicionEnEL11> posi11Info= Optional.of(new PosicionEnEL11());
		Optional<PosicionEnEL11> posi11InfoFront= Optional.of(new PosicionEnEL11());
		PosicionEnEL11 posi11Insert = new PosicionEnEL11();
		Optional<Jugador> posiJugador = Optional.of(new Jugador());
		
		//Saber que posicion es el jugador
		posiJugador = jugadorRepo.findById(jugadorId.getId());
		
		// Variable para saber cuando no entrar al bucle
		int salir = 0;
		
		// Parte Delantero
		if (posiJugador.get().getPosicion().getNombre().equals("Delantero")) {
			
			for (int i = 1; i < 4; i++) {
				
				posi11Info = posicionEnEl11Repo.findById(i);
				
				if (posi11Info.get().getJugador().getId() == 0 && salir == 0) {
					
					posi11Insert.setId(posi11Info.get().getId());
					posi11Insert.setJugador(jugadorId);
					
					salir = 1;
					
					posicionEnEl11Repo.save(posi11Insert);
				}
				
			}
		
		// Parte Mediocentro
		}else if (posiJugador.get().getPosicion().getNombre().equals("Mediocentro")) {
			
			for (int i = 4; i < 7; i++) {
				
				posi11Info = posicionEnEl11Repo.findById(i);
				
				if (posi11Info.get().getJugador().getId() == 0 && salir == 0) {
					
					posi11Insert.setId(posi11Info.get().getId());
					posi11Insert.setJugador(jugadorId);
					
					salir = 1;
					
					posicionEnEl11Repo.save(posi11Insert);
				}
				
			}
		
		// Parte Defensa
		}else if (posiJugador.get().getPosicion().getNombre().equals("Defensa")) {
			
			for (int i = 7; i < 11; i++) {
				
				posi11Info = posicionEnEl11Repo.findById(i);
				
				if (posi11Info.get().getJugador().getId() == 0 && salir == 0) {
					
					posi11Insert.setId(posi11Info.get().getId());
					posi11Insert.setJugador(jugadorId);
					
					salir = 1;
					
					posicionEnEl11Repo.save(posi11Insert);
				}
				
			}
		
		// Parte Portero
		} else {
			
			for (int i = 11; i < 12; i++) {
				
				posi11Info = posicionEnEl11Repo.findById(i);
				
				if (posi11Info.get().getJugador().getId() == 0 && salir == 0) {
					
					posi11Insert.setId(posi11Info.get().getId());
					posi11Insert.setJugador(jugadorId);
					
					salir = 1;
					
					posicionEnEl11Repo.save(posi11Insert);
				}
				
			}
			
		}
		
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
		
		// Atributos que usaremos para validar los datos en el front 
		model.addAttribute("delanteroNumero", DelanteroNumero);
		model.addAttribute("mediocentroNumero", MediocentroNumero);
		model.addAttribute("defensaNumero", DefensaNumero);
		model.addAttribute("porteroNumero", PorteroNumero);
		
		// Filtro para que no se puede añadir dos veces el mismo jugador
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

		return "index";	

	}
	
	// Solicitud para quitar el jugador del 11, poniendo como recambio a un jugador default que tiene el id "0"
	@RequestMapping("/quitarDel11")
	public String quitarDel11(@RequestParam("posicionId") PosicionEnEL11 posicionId, Model model) {

		model.addAttribute("atr_lista_posiciones11", posicionEnEl11Repo.findAll());
		model.addAttribute("atr_lista_puntuacion", puntuacionRepo.findAll());
		model.addAttribute("atr_lista_jugadores", jugadorRepo.findAll());
		
		List<Jugador> listajugadores = jugadorRepo.findAll();
		
		// Inicializamos los objetos
		Optional<PosicionEnEL11> posi11= Optional.of(new PosicionEnEL11());
		Optional<PosicionEnEL11> posi11InfoFront= Optional.of(new PosicionEnEL11());
		PosicionEnEL11 posi11Insert = new PosicionEnEL11();
		
		// Recogemos los datos del jugador que queremos quitar del 11
		posi11 = posicionEnEl11Repo.findById(posicionId.getId());
		
		// Cambiamos al jugador por el "default"
		posi11Insert.setId(posi11.get().getId());
		posi11Insert.setJugador(listajugadores.get(0));
		
		posicionEnEl11Repo.save(posi11Insert);

		// Para que aparezcan los puntos en total de la jornada hecha por los jugadores
		List<PosicionEnEL11> posi11Lista = posicionEnEl11Repo.findAll();
		int puntuacionTotal = 0;
		
		for (PosicionEnEL11 posi11Lis : posi11Lista) {
		
		puntuacionTotal = puntuacionTotal + posi11Lis.getJugador().getPuntos();
				
		}
		
		model.addAttribute("puntosTotal", puntuacionTotal);
		
		// Devolvemos la vista
		return "campoConJugadores";	

	}
	
	// Solicitud para filtrar la lista de jugadores por el equipo seleccionado
	@RequestMapping("/filtroEquipo")
	public String filtroEquipo(@RequestParam("idEquipo") int idEquipo,Model model) {
		
		// Llamada a la funcion con la id del equipo del que queremos filtrar los datos
		List<Jugador> listaJugadoresFiltrado = jugadorRepo.findByEquipoId(idEquipo);
		
		
		model.addAttribute("atr_lista_jugadores", listaJugadoresFiltrado);
		
		model.addAttribute("atr_lista_puntuacion", puntuacionRepo.findAll());
		model.addAttribute("atr_lista_posiciones11", posicionEnEl11Repo.findAll());
		model.addAttribute("atr_lista_equipos", equiposRepo.findAll());
		model.addAttribute("atr_lista_posiciones", posicionRepo.findAll());
		
		// Inicializamos los objetos
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
		
		model.addAttribute("delanteroNumero", DelanteroNumero);
		model.addAttribute("mediocentroNumero", MediocentroNumero);
		model.addAttribute("defensaNumero", DefensaNumero);
		model.addAttribute("porteroNumero", PorteroNumero);
		
		// Filtro para que no se puede añadir dos veces el mismo jugador
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
	
	// Solicitud para filtrar por la posicion del jugador seleccionada
	@RequestMapping("/filtroPosicion")
	public String filtroPosicion(@RequestParam("idPosicion") int idPosicion,Model model) {
		
		// Recogemos los datos de los jugadores con la posicion seleccionada
		List<Jugador> listaPosicionesFiltrado = jugadorRepo.findByPosicionId(idPosicion);
		
		model.addAttribute("atr_lista_jugadores", listaPosicionesFiltrado);
		model.addAttribute("atr_lista_puntuacion", puntuacionRepo.findAll());
		model.addAttribute("atr_lista_posiciones11", posicionEnEl11Repo.findAll());
		model.addAttribute("atr_lista_equipos", equiposRepo.findAll());
		model.addAttribute("atr_lista_posiciones", posicionRepo.findAll());
		
		// Inicializamos los objetos
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
	
	// Solicitud para la asignacion de goles y asistencias por probabilidad, siendo esta el numero del precio de cada uno
	@RequestMapping("/asignarGolesAsist")
	public String asignarGolesAsist() {
        
		// Recogemos los datos de la jornada
		List<Jornada> listajornada = jornadaRepo.findAll();
		
		// Inicializamos el objeto random
		Random random = new Random();
		
		// Por jornada habra que asignar los goles al equipo de casa y al visitante ya que la base de datos esta diseñada asi
		for (Jornada jornada : listajornada) {
			
			// Guardamos los goles de casa y de fuera
		    int golesEquipoCasa = jornada.getEquipoCasaMarcador();
		    int golesEquipoFuera = jornada.getEquipoVisitanteMarcador();
		    
		    // Recogemos los datos de los jugadores de cada equipo
		    List<Jugador> listaJugadoresPorEquipoCasa = jugadorRepo.findByEquipoId(jornada.getIdequipoCasa());
		    List<Jugador> listaJugadoresPorEquipoFuera = jugadorRepo.findByEquipoId(jornada.getIdequipoVisitante());
		    Jugador jugadorId = new Jugador();
		    
		    // Iniciamos un bucle por cada gol
		    for (int i = 0; i < golesEquipoCasa; i++) {
				
		    	// Randomizamos los jugadores en la lista para que no empiece siempre por los delanteros al probar si mete gol o no
		    	Collections.shuffle(listaJugadoresPorEquipoCasa);
		    	
		    	// Variable para saber si todavia el gol se ha asignado o no 
		    	int  e = 1;
		    	
		    	// Un while para 
		    	while (e != 0) {
		    		
		    		for (Jugador jugador : listaJugadoresPorEquipoCasa) {		   		    			
						
		    			int numeroRandom = random.nextInt(100) + 1;
		    			
		    			// Si el precio del jugador entra en el rango del numero random, se le asignara el gol
			    		if (numeroRandom <= jugador.getPrecio()) {
							
			    			// Inicializamos el objeto Contribucion
			    			Contribucion jugadorGoleador = new Contribucion();

			    			// Lista de los datos de las contribuciones del jugador
			    			List<Contribucion> jugadorInfo = contribucionRepo.findById(jugador.getId());
					        
			    			jugadorGoleador.setId(jugador.getId());
			    			
			    			for (Contribucion jugadorEspecificoInfo : jugadorInfo) {
				    			jugadorGoleador.setAsist(jugadorEspecificoInfo.getAsist());
				    			jugadorGoleador.setGol(jugadorEspecificoInfo.getGol() + e);
				    			jugadorGoleador.setJugador(jugador);
			    			}					      

					        
			    			contribucionRepo.save(jugadorGoleador);
			    			
			    			// Asignamos valor nulo a la variable para que salga del bucle y si vuelve a asignar un gol por probabilidad no se le sume ninguno mas
			    			e=0;			    		
			    			
			    			jugadorId.setId(jugador.getId());
			    					    			
			    			
						}
		    			
					}
		    		
				}
		    	
		    	// Eliminamos el jugador de la lista de jugadores para que no se le asigne la asistencia del mismo gol que ha metido
    			List<Jugador> listaJugadoresPorEquipoCasaFIltrado = listaJugadoresPorEquipoCasa;
    			listaJugadoresPorEquipoCasaFIltrado.removeIf(jugadorEliminar -> jugadorEliminar.getId() == jugadorId.getId());
    			
		    	
    			// Misma logica para la parte de las asistencias
    			int a = 1;
    			
    			while (a != 0) {
    				
    				for (Jugador jugadorEspecifico : listaJugadoresPorEquipoCasaFIltrado) {
    					
    					int numeroRandomEspecifico = random.nextInt(100) + 1;
    					
    					if (numeroRandomEspecifico <= jugadorEspecifico.getPrecio()) {
    						
    						Contribucion jugadorGoleadorEspecifico = new Contribucion();
    						
    						List<Contribucion> jugadorInfoEspecifico = contribucionRepo.findById(jugadorEspecifico.getId());
    						
    						jugadorGoleadorEspecifico.setId(jugadorEspecifico.getId());
			    			
			    			for (Contribucion jugadorEspecificoInfoBucle : jugadorInfoEspecifico) {
			    				jugadorGoleadorEspecifico.setAsist(jugadorEspecificoInfoBucle.getAsist() + a);
			    				jugadorGoleadorEspecifico.setGol(jugadorEspecificoInfoBucle.getGol());
			    				jugadorGoleadorEspecifico.setJugador(jugadorEspecifico);
			    			}					      

			    			contribucionRepo.save(jugadorGoleadorEspecifico);
    						
    						a = 0;
    						
    					}
    					
    				}
    				
    			}
		    	
			}
		    
		    // Misma logica para la parte del equipo de fuera
		    for (int i = 0; i < golesEquipoFuera; i++) {
				
		    	Collections.shuffle(listaJugadoresPorEquipoFuera);
		    	
		    	int  ee = 1;
		    	
		    	while (ee != 0) {
		    		
		    		for (Jugador jugador : listaJugadoresPorEquipoFuera) {
						
		    			int numeroRandom = random.nextInt(100) + 1;
		    			
			    		if (numeroRandom <= jugador.getPrecio()) {
							
			    			Contribucion jugadorGoleador = new Contribucion();

			    			List<Contribucion> jugadorInfo = contribucionRepo.findById(jugador.getId());
					        
			    			jugadorGoleador.setId(jugador.getId());
			    			
			    			for (Contribucion jugadorEspecificoInfo : jugadorInfo) {
				    			jugadorGoleador.setAsist(jugadorEspecificoInfo.getAsist());
				    			jugadorGoleador.setGol(jugadorEspecificoInfo.getGol() + ee);
				    			jugadorGoleador.setJugador(jugador);
			    			}					      

					        
			    			contribucionRepo.save(jugadorGoleador);
			    			
			    			ee=0;	
			    			
						}
		    			
					}
		    		
				}
		    	
    			List<Jugador> listaJugadoresPorEquipoFueraFiltrado = listaJugadoresPorEquipoFuera;
    			listaJugadoresPorEquipoFueraFiltrado.removeIf(jugadorEliminar -> jugadorEliminar.getId() == jugadorId.getId());
		    	
    			int aa = 1;
    			
    			while (aa != 0) {
    				
    				for (Jugador jugadorEspecificoFuera : listaJugadoresPorEquipoFueraFiltrado) {
    					
    					int numeroRandomEspecifico = random.nextInt(100) + 1;
    					
    					if (numeroRandomEspecifico <= jugadorEspecificoFuera.getPrecio()) {
    						
    						Contribucion jugadorGoleadorEspecificoFuera = new Contribucion();
    						
    						List<Contribucion> jugadorInfoEspecificoFuera = contribucionRepo.findById(jugadorEspecificoFuera.getId());
    						
    						jugadorGoleadorEspecificoFuera.setId(jugadorEspecificoFuera.getId());
			    			
			    			for (Contribucion jugadorEspecificoInfoBucle : jugadorInfoEspecificoFuera) {
			    				jugadorGoleadorEspecificoFuera.setAsist(jugadorEspecificoInfoBucle.getAsist() + aa);
			    				jugadorGoleadorEspecificoFuera.setGol(jugadorEspecificoInfoBucle.getGol());
			    				jugadorGoleadorEspecificoFuera.setJugador(jugadorEspecificoFuera);
			    			}					      

			    			contribucionRepo.save(jugadorGoleadorEspecificoFuera);
    						
    						aa = 0;
    						
    					}
    					
    				}
    				
    			}
		    	
			}
		    
		}
		
		// Devolvemos la vista
		return "jornada";
		
	}
	
	// Solicitud para reiniciar los marcadores
	@RequestMapping("/reiniciarMarcadores")
	public void reiniciarMarcadores() {

		List<Jugador> jugadores = jugadorRepo.findAll();
		
		for (int i = 1; i < jugadores.size(); i++) {
			// Servicio para reiniciar los goles y asistencias a 0
			servicios.resetAsistGol(i);
			
		}

	}
	
	// Solicitud para calcular los puntos
	@RequestMapping("/calcularPuntos")
	public String calcularPuntos() {

		List<Jugador> jugadores = jugadorRepo.findAll();
		
		// El jugador 0 utilizado para ponerlo como default hace que tengamos que utilizar un bucle con itineracion basica
		for (int i = 1; i < jugadores.size(); i++) {
			
			Optional<Jugador> jugador = jugadorRepo.findById(i);
			List<Contribucion> jugadorInfo = contribucionRepo.findById(jugador.get().getId());
			
			int puntos = 0;
			
			// Formula para calcular los puntos
			puntos = puntos + (jugadorInfo.get(0).getGol() * 4) + (jugadorInfo.get(0).getAsist()*3);
			
			servicios.actualizarPuntos(jugador.get().getId(), puntos);
			
		}

		// Retornamos la vista
		return "jornada";	

	}
	
	// Solicitud para enseñar las contribuciones por pantalla
	@RequestMapping("/enseñarContribuciones")
	public String enseñarContribuciones(Model model) {

		model.addAttribute("atr_lista_jugadores", jugadorRepo.findAll());
		model.addAttribute("atr_lista_contribuciones", contribucionRepo.findAll());
		
		// Devolvemos la vista
		return "marcadores";	
	}
	
	// Filtro de los goles por maximo a minimo
	@RequestMapping("/filtroMaxGoles")
	public String filtroMaxGoles(Model model) {

		model.addAttribute("atr_lista_jugadores", jugadorRepo.findAll());
		model.addAttribute("atr_lista_contribuciones",  contribucionRepo.findAllByOrderByGolDesc());
		
		return "marcadores";	

	}
	
	// Filtro de goles por minimo a maximo
	@RequestMapping("/filtroMinGoles")
	public String filtroMinGoles(Model model) {

		model.addAttribute("atr_lista_jugadores", jugadorRepo.findAll());
		model.addAttribute("atr_lista_contribuciones",  contribucionRepo.findAllByOrderByGolAsc());
		
		return "marcadores";	

	}
	
	// Filtro Asistencias de maximo a minimo
	@RequestMapping("/filtroMaxAsist")
	public String filtroMaxAsist(Model model) {

		model.addAttribute("atr_lista_jugadores", jugadorRepo.findAll());
		model.addAttribute("atr_lista_contribuciones",  contribucionRepo.findAllByOrderByAsistDesc());
		
		return "marcadores";	

	}
	
	// Filtro de goles de minimo a maximo
	@RequestMapping("/filtroMinAsist")
	public String filtroMinAsist(Model model) {

		model.addAttribute("atr_lista_jugadores", jugadorRepo.findAll());
		model.addAttribute("atr_lista_contribuciones",  contribucionRepo.findAllByOrderByAsistAsc());
		
		return "marcadores";	

	}

}

