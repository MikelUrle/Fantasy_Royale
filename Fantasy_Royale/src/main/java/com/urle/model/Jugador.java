package com.urle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="jugadores")
public class Jugador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="precio")
	private int precio;
	
	@Column(name="foto")
	private String foto;
	
	@ManyToOne
	private Equipo equipo;
	
	@ManyToOne
	private Posicion posicion;
	
	@Column(name="puntos")
	private int puntos;

	public Jugador(int id, String nombre, int precio, String foto, Equipo equipo, Posicion posicion, int puntos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.foto = foto;
		this.equipo = equipo;
		this.posicion = posicion;
		this.puntos = puntos;
	}

	public Jugador() {
		super();
		this.id = 0;
		this.nombre = "";
		this.precio = 0;
		this.foto = "";
		this.equipo = new Equipo();
		this.posicion = new Posicion();
		this.puntos = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", foto=" + foto + ", equipo="
				+ equipo + ", posicion=" + posicion + ", puntos=" + puntos + "]";
	}
	
}
