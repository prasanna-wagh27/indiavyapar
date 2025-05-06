package com.indiavyapar.webservice.service;

import java.util.UUID;

import com.indiavyapar.webservice.bo.ProductBO;
import com.indiavyapar.webservice.bo.Response;

public interface ProductService {

	void createProduct(ProductBO productBO) throws Exception;

	Response getProductById(UUID productId) throws Exception;

}
