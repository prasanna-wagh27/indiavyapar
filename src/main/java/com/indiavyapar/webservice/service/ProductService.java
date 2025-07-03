package com.indiavyapar.webservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.indiavyapar.webservice.bo.ProductBO;
import com.indiavyapar.webservice.bo.Response;

public interface ProductService {

	void createProduct( List<MultipartFile> images,ProductBO productBO) throws Exception;

	Response getProductById(UUID productId) throws Exception;
	
	Response getAllProductsByWebsite(UUID websiteId, Pageable pageable) throws Exception;

	Response getAllActiveProductsByWebsite(UUID websiteId, Pageable pageable) throws Exception;

	void updateProduct(UUID productId, ProductBO productBO) throws Exception;


}
