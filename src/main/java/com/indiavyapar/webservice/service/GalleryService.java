package com.indiavyapar.webservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.indiavyapar.webservice.bo.GalleryBO;
import com.indiavyapar.webservice.bo.Response;

public interface GalleryService {

	void uploadImages(UUID websiteId, List<MultipartFile> images) throws Exception;

	void updateGallery(UUID galleryId, GalleryBO galleryBO, MultipartFile image) throws Exception;

	Response getGalleryById(UUID galleryId) throws Exception;

	Response getAllGalleryByWebsite(UUID websiteId, Pageable pageable)
			throws Exception;

	void deleteImageById(UUID galleryId) throws Exception;

}
