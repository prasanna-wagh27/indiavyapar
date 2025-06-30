package com.indiavyapar.webservice.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.indiavyapar.webservice.entity.District;
import com.indiavyapar.webservice.entity.State;

public interface DistrictRepository extends JpaRepository<District, UUID>{

	@Query("SELECT d FROM District d WHERE(:stateId IS NULL OR d.state.stateId = :stateId)")
	Page<District> getAllDistrictsByState(@Param("stateId") UUID stateId, Pageable pageable);

	@Query("SELECT d FROM District d WHERE(:stateId IS NULL OR d.state.stateId = :stateId) "
			+ "AND d.status = true")
	Page<District> getActiveDistricts(@Param("stateId") UUID stateId, Pageable pageable);

	boolean existsByStateAndDistrictName(State state, String districtName);
	
}
