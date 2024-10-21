package com.urle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urle.model.Puntuacion;

@Repository
public interface PuntuacionRepository extends JpaRepository<Puntuacion, Integer> {

}