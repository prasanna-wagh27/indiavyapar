package com.indiavyapar.webservice.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.indiavyapar.webservice.bo.GalleryBO;
import com.indiavyapar.webservice.bo.Response;

public interface GalleryService {

	void createGallery(GalleryBO galleryBO) throws Exception;

	void updateGallery(UUID galleryId, GalleryBO galleryBO) throws Exception;

	Response getGalleryById(UUID galleryId) throws Exception;

	Response getAllGalleryByWebsite(UUID websiteId, Pageable pageable)
			throws Exception;

	Response getActiveGalleryByWebsite(UUID websiteId, Pageable pageable)
			throws Exception;

}
