package com.indiavyapar.webservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.entity.Product;
import com.indiavyapar.webservice.entity.ProductImage;
import com.indiavyapar.webservice.exception.IndiaVyaparException;
import com.indiavyapar.webservice.repository.ProductImageRepository;
import com.indiavyapar.webservice.repository.ProductRepository;
import com.indiavyapar.webservice.service.ProductImageService;
import com.indiavyapar.webservice.utility.FileUtility;

@Service
public class ProductImageServiceImpl implements ProductImageService {

	@Autowired
	private ProductImageRepository productImageRepo;

	@Autowired
	private FileUtility fileUtility;

	@Autowired
	private ProductRepository productRepo;

	@Override
	public void deleteImage(UUID productImageId) throws Exception {

		productImageRepo.deleteById(productImageId);
	}

	@Override
	public void addImages(UUID productId, List<MultipartFile> images) throws Exception {

		if (images == null || images.isEmpty()) {
			throw new IllegalArgumentException("No images provided to upload.");
		}

		Product existingProduct = productRepo.findById(productId)
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Product Not Found"));

		List<ProductImage> imageEntities = new ArrayList<>();

		for (MultipartFile file : images) {
			ProductImage productImage = new ProductImage();
			productImage.setProduct(existingProduct);
			productImage.setImageUrl(fileUtility.saveImage(file));
			imageEntities.add(productImage);
		}
		productImageRepo.saveAll(imageEntities);
	}

}
