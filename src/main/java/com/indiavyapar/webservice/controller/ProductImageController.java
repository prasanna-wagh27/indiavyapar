package com.indiavyapar.webservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.service.ProductImageService;

@RestController
@RequestMapping("${url.prefix}/product-image")
public class ProductImageController {
	
	@Autowired
	private ProductImageService productImageService;
	
	@CrossOrigin
	@DeleteMapping("/{productImageId}")
	public ResponseEntity<Response> deleteImage(@PathVariable("productImageId") UUID productImageId) throws Exception{
		productImageService.deleteImage(productImageId);
		Response response = new Response();
		response.setMessage("Image Deleted successfully");
		response.setStatus(ErrorConstants.SUCCESS.toString());
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/{productId}")
	public ResponseEntity<Response> addImages(@PathVariable("productId") UUID productId,
			@RequestPart("images") List<MultipartFile> images) throws Exception{
		productImageService.addImages(productId, images);
		Response response = new Response();
		response.setMessage("Images added successfully");
		response.setStatus(ErrorConstants.SUCCESS.toString());
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
