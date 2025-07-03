package com.indiavyapar.webservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public interface ProductImageService {

	void deleteImage(UUID productImageId) throws Exception;

	void addImages(UUID productId, List<MultipartFile> images) throws Exception;

}
