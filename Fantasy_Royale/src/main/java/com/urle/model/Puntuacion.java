package com.urle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="puntuacion")
public class Puntuacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="puntos")
	private int puntos;

	@ManyToOne
	private Jugador jugador;

	public Puntuacion(int id, int puntos, Jugador jugador) {
		super();
		this.id = id;
		this.puntos = puntos;
		this.jugador = jugador;
	}

	public Puntuacion() {
		super();
		this.id = 0;
		this.puntos = 0;
		this.jugador = new Jugador();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public String toString() {
		return "Puntuacion [id=" + id + ", puntos=" + puntos + ", jugador=" + jugador + "]";
	}
	
}
