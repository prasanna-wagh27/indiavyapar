package com.indiavyapar.webservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indiavyapar.webservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, UUID>{

}
