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

import com.indiavyapar.webservice.bo.GalleryBO;
import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.service.GalleryService;

@RestController
@RequestMapping("${url.prefix}/gallery")
public class GalleryController {

	@Autowired
	private GalleryService galleryService;

	@CrossOrigin
	@PostMapping("/{websiteId}")
	public ResponseEntity<Response> uploadImages(@PathVariable("websiteId") UUID websiteId,
			@RequestPart("images") List<MultipartFile> images) throws Exception {
		galleryService.uploadImages(websiteId, images);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Gallery images saved successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/update/{galleryId}")
	public ResponseEntity<Response> updateGallery(@PathVariable UUID galleryId,
			@RequestPart("galleryBO") GalleryBO galleryBO,
			@RequestPart(value = "image", required = false) MultipartFile image) throws Exception {
		galleryService.updateGallery(galleryId, galleryBO, image);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Gallery image updated successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/{galleryId}")
	public ResponseEntity<Response> getImageById(@PathVariable UUID galleryId) throws Exception {
		Response response = galleryService.getGalleryById(galleryId);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/website/{websiteId}")
	public ResponseEntity<Response> getAllImagesByWebsite(@PathVariable UUID websiteId,
			@PageableDefault(page = 0, size = 10) @SortDefault(sort = "galleryId", direction = Sort.Direction.ASC) Pageable pageable)
			throws Exception {
		Response response = galleryService.getAllGalleryByWebsite(websiteId, pageable);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@DeleteMapping("/{galleryId}")
	public ResponseEntity<Response> deleteImageById(@PathVariable UUID galleryId) throws Exception {
		galleryService.deleteImageById(galleryId);
		Response response = new Response();
		response.setMessage("Image deleted successfully");
		response.setStatus(ErrorConstants.SUCCESS.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}