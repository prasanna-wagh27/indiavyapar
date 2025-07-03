package com.indiavyapar.webservice.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.indiavyapar.webservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

	@Query("SELECT p FROM Product p JOIN FETCH p.images WHERE p.website.websiteId = :websiteId")
	Page<Product> findAllByWebsiteId(@Param("websiteId") UUID websiteId, Pageable pageable);

	@Query("SELECT p FROM Product p JOIN FETCH p.images WHERE (p.website.websiteId = :websiteId) AND p.isActive=TRUE ")
	Page<Product> findAllActiveByWebsiteId(@Param("websiteId") UUID websiteId, Pageable pageable);


}
