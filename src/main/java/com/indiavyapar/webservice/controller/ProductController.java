package com.indiavyapar.webservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indiavyapar.webservice.bo.ProductBO;
import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.service.ProductService;

@RestController
@RequestMapping("${url.prefix}/website/product")
public class ProductController {
	
	 @Autowired
	    private ProductService productService;

	    @CrossOrigin
	    @PostMapping("/create")
	    public ResponseEntity<Response> createProduct(@RequestBody ProductBO productBO) throws Exception {
	        productService.createProduct(productBO);
	        Response response = new Response();
	        response.setStatus(ErrorConstants.SUCCESS.toString());
	        response.setMessage("Product created successfully");
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    @CrossOrigin
	    @GetMapping("/{productId}")
	    public ResponseEntity<Response> getProductById(@PathVariable UUID productId) throws Exception {
	        Response response = productService.getProductById(productId);
	        response.setStatus(ErrorConstants.SUCCESS.toString());
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

}
