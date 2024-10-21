package com.urle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urle.model.PosicionEnEL11;

@Repository
public interface PosicionEnEl11Repository extends JpaRepository<PosicionEnEL11, Integer> {

}

