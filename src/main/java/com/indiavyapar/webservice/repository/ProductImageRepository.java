package com.indiavyapar.webservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indiavyapar.webservice.entity.Product;
import com.indiavyapar.webservice.entity.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, UUID>{

	List<ProductImage> findAllByProduct(Product product);


}
