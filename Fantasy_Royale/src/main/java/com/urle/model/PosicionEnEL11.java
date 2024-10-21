package com.urle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="posicionEnEL11")
public class PosicionEnEL11 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	private Jugador jugador;

	public PosicionEnEL11(int id, Jugador jugador) {
		super();
		this.id = id;
		this.jugador = jugador;
	}

	public PosicionEnEL11() {
		super();
		this.id = 0;
		this.jugador = new Jugador();
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

	@Override
	public String toString() {
		return "PosicionEnEL11 [id=" + id + ", jugador=" + jugador + "]";
	}
	
}

