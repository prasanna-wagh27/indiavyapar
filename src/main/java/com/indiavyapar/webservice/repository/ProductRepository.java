package com.indiavyapar.webservice.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.indiavyapar.webservice.entity.Product;
import com.indiavyapar.webservice.entity.Website;

public interface ProductRepository extends JpaRepository<Product, UUID> {

	Page<Product> findAllByWebsite(Website website, Pageable pageable);

	Page<Product> findAllByWebsiteAndIsActiveTrue(Website website, Pageable pageable);

}
