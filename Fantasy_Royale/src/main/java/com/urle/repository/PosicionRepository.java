package com.urle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urle.model.Posicion;

@Repository
public interface PosicionRepository extends JpaRepository<Posicion, Integer> {

}

