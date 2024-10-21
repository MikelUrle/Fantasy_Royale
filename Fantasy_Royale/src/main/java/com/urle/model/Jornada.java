package com.urle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="jornada")
public class Jornada {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="equipoCasa")
	private String equipoCasa;
	
	@Column(name="idequipoCasa")
	private int idequipoCasa;
	
	@Column(name="equipoVisitante")
	private String equipoVisitante;
	
	@Column(name="idequipoVisitante")
	private int idequipoVisitante;

	@Column(name="equipoCasaMarcador")
	private int equipoCasaMarcador;
	
	@Column(name="equipoVisitanteMarcador")
	private int equipoVisitanteMarcador;

	public Jornada(int id, String equipoCasa, int idequipoCasa, String equipoVisitante, int idequipoVisitante,
			int equipoCasaMarcador, int equipoVisitanteMarcador) {
		super();
		this.id = id;
		this.equipoCasa = equipoCasa;
		this.idequipoCasa = idequipoCasa;
		this.equipoVisitante = equipoVisitante;
		this.idequipoVisitante = idequipoVisitante;
		this.equipoCasaMarcador = equipoCasaMarcador;
		this.equipoVisitanteMarcador = equipoVisitanteMarcador;
	}

	public Jornada() {
		super();
		this.id = 0;
		this.equipoCasa = "";
		this.idequipoCasa = 0;
		this.equipoVisitante = "";
		this.idequipoVisitante = 0;
		this.equipoCasaMarcador = 0;
		this.equipoVisitanteMarcador = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEquipoCasa() {
		return equipoCasa;
	}

	public void setEquipoCasa(String equipoCasa) {
		this.equipoCasa = equipoCasa;
	}

	public int getIdequipoCasa() {
		return idequipoCasa;
	}

	public void setIdequipoCasa(int idequipoCasa) {
		this.idequipoCasa = idequipoCasa;
	}

	public String getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public int getIdequipoVisitante() {
		return idequipoVisitante;
	}

	public void setIdequipoVisitante(int idequipoVisitante) {
		this.idequipoVisitante = idequipoVisitante;
	}

	public int getEquipoCasaMarcador() {
		return equipoCasaMarcador;
	}

	public void setEquipoCasaMarcador(int equipoCasaMarcador) {
		this.equipoCasaMarcador = equipoCasaMarcador;
	}

	public int getEquipoVisitanteMarcador() {
		return equipoVisitanteMarcador;
	}

	public void setEquipoVisitanteMarcador(int equipoVisitanteMarcador) {
		this.equipoVisitanteMarcador = equipoVisitanteMarcador;
	}

	@Override
	public String toString() {
		return "Jornada [id=" + id + ", equipoCasa=" + equipoCasa + ", idequipoCasa=" + idequipoCasa
				+ ", equipoVisitante=" + equipoVisitante + ", idequipoVisitante=" + idequipoVisitante
				+ ", equipoCasaMarcador=" + equipoCasaMarcador + ", equipoVisitanteMarcador=" + equipoVisitanteMarcador
				+ "]";
	}
	
}
