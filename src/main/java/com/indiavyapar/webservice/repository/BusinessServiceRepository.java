package com.indiavyapar.webservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.indiavyapar.webservice.entity.BusinessService;

public interface BusinessServiceRepository extends JpaRepository<BusinessService, UUID>{
	
	@Query("SELECT bs FROM BusinessService bs WHERE bs.website.websiteId = :websiteId")
	List<BusinessService> findAllByWebsiteId(@Param("websiteId") UUID websiteId);

}
