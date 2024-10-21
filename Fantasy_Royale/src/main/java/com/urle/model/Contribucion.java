package com.urle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="contribucion")
public class Contribucion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	private Jugador jugador;
	
	@Column(name="gol")
	private int gol;
	
	@Column(name="asist")
	private int asist;

	public Contribucion(int id, Jugador jugador, int gol, int asist) {
		super();
		this.id = id;
		this.jugador = jugador;
		this.gol = gol;
		this.asist = asist;
	}

	public Contribucion() {
		super();
		this.id = 0;
		this.jugador = new Jugador();
		this.gol = 0;
		this.asist = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getGol() {
		return gol;
	}

	public void setGol(int gol) {
		this.gol = gol;
	}

	public int getAsist() {
		return asist;
	}

	public void setAsist(int asist) {
		this.asist = asist;
	}

	@Override
	public String toString() {
		return "Contribucion [id=" + id + ", jugador=" + jugador + ", gol=" + gol + ", asist=" + asist + "]";
	}
	
}

