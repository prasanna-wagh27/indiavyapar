package com.indiavyapar.webservice.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.indiavyapar.webservice.bo.ProductBO;
import com.indiavyapar.webservice.bo.Response;

public interface ProductService {

	void createProduct(ProductBO productBO) throws Exception;

	Response getProductById(UUID productId) throws Exception;
	
	Response getAllProductsByWebsite(UUID websiteId, Pageable pageable) throws Exception;

	Response getAllActiveProductsByWebsite(UUID websiteId, Pageable pageable) throws Exception;

	void updateProduct(UUID productId, ProductBO productBO) throws Exception;


}
