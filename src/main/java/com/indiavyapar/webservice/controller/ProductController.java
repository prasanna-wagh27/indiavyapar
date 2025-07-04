package com.indiavyapar.webservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.indiavyapar.webservice.bo.ProductBO;
import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.service.ProductService;

@RestController
@RequestMapping("${url.prefix}/product")
public class ProductController {
	
	 @Autowired
	    private ProductService productService;

	    @CrossOrigin
	    @PostMapping("/create")
	    public ResponseEntity<Response> createProduct(@RequestPart("images") List<MultipartFile> images,
	    		@RequestPart("productBO") ProductBO productBO) throws Exception {
	        productService.createProduct(images, productBO);
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
	    
	    @CrossOrigin
	    @GetMapping("/website/{websiteId}")
	    public ResponseEntity<Response> getAllProductsByWebsite(@PathVariable UUID websiteId,
	    		   @PageableDefault(page = 0, size = 10)
        @SortDefault(sort = "productId", direction = Sort.Direction.ASC) Pageable pageable) throws Exception {
	        Response response = productService.getAllProductsByWebsite(websiteId, pageable);
	        response.setStatus(ErrorConstants.SUCCESS.toString());
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    @CrossOrigin
	    @GetMapping("/website/{websiteId}/active")
	    public ResponseEntity<Response> getAllActiveProductsByWebsite(@PathVariable UUID websiteId,
	    		   @PageableDefault(page = 0, size = 10)
        @SortDefault(sort = "productId", direction = Sort.Direction.ASC) Pageable pageable) throws Exception {
	        Response response = productService.getAllActiveProductsByWebsite(websiteId, pageable);
	        response.setStatus(ErrorConstants.SUCCESS.toString());
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    @CrossOrigin
	    @PutMapping("/update/{productId}")
	    public ResponseEntity<Response> updateProduct(@PathVariable UUID productId, @RequestPart("productBO") ProductBO productBO) throws Exception {
	        productService.updateProduct(productId, productBO);
	        Response response = new Response();
	        response.setStatus(ErrorConstants.SUCCESS.toString());
	        response.setMessage("Product updated successfully");
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
	    
	    @CrossOrigin
	    @DeleteMapping("/{productId}")
	    public ResponseEntity<Response> deleteProduct(@PathVariable UUID productId) throws Exception {
	        productService.deleteProduct(productId);
	        Response response = new Response();
	        response.setStatus(ErrorConstants.SUCCESS.toString());
	        response.setMessage("Product deleted successfully");
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }


}
