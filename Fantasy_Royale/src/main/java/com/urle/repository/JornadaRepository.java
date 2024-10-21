package com.urle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urle.model.Jornada;

@Repository
public interface JornadaRepository extends JpaRepository<Jornada, Integer> {

}
