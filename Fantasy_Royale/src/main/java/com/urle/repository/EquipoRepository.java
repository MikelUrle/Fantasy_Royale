package com.urle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urle.model.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {

}

