package com.indiavyapar.webservice.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.indiavyapar.webservice.entity.State;

public interface StateRepository extends JpaRepository<State, UUID>{

	boolean existsByStateName(String stateName);
	
	Page<State> findAll(Pageable pageable);

	Page<State> findByStatus( boolean status, Pageable pageable);

}
