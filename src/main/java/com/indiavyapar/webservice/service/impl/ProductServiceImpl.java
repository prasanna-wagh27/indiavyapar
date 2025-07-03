package com.indiavyapar.webservice.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.indiavyapar.webservice.bo.ProductBO;
import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.entity.Product;
import com.indiavyapar.webservice.entity.ProductImage;
import com.indiavyapar.webservice.entity.Website;
import com.indiavyapar.webservice.exception.IndiaVyaparException;
import com.indiavyapar.webservice.repository.ProductImageRepository;
import com.indiavyapar.webservice.repository.ProductRepository;
import com.indiavyapar.webservice.repository.WebsiteRepository;
import com.indiavyapar.webservice.service.ProductService;
import com.indiavyapar.webservice.utility.FileUtility;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private WebsiteRepository websiteRepo;
	
	@Autowired
	private ProductImageRepository productImageRepo;
	
	@Autowired
	private FileUtility fileUtility;
	

	@Override
	@Transactional
	public void createProduct( List<MultipartFile> images,ProductBO productBO) throws Exception {
		Website website = websiteRepo.findById(productBO.getWebsiteId())
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));

		Product product = new Product();
		product.setProductName(productBO.getProductName());
		product.setDescription(productBO.getDescription());
		product.setPrice(productBO.getPrice());
		product.setActive(productBO.isActive());
		product.setWebsite(website);
		
		for(MultipartFile image : images) {
			String filePath = fileUtility.saveImage(image);
	        ProductImage imageEntity = new ProductImage();
	        imageEntity.setProduct(product);
	        imageEntity.setImageUrl(filePath);
	        productImageRepo.save(imageEntity);
		}
		productRepo.save(product);
	}

	@Override
	public Response getProductById(UUID productId) throws Exception {
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Product not found"));

		List<ProductImage> images = productImageRepo.findAllByProduct(product);
		if(!images.isEmpty()) {
			product.setImages(images);
		}
		Response response = new Response();
		response.setMessage("Product details");
		response.setData(product);
		return response;
	}

	@Override
	public Response getAllProductsByWebsite(UUID websiteId, Pageable pageable) throws Exception {
		Website website = websiteRepo.findById(websiteId)
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));

		Page<Product> products = productRepo.findAllByWebsiteId(website.getWebsiteId(), pageable);

		Response response = new Response();
		response.setMessage("All products for website");
		response.setData(products.getContent());
		response.setListCount(products.getTotalElements());
		return response;
	}

	@Override
	public Response getAllActiveProductsByWebsite(UUID websiteId, Pageable pageable) throws Exception {
		Website website = websiteRepo.findById(websiteId)
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));

		Page<Product> products = productRepo.findAllActiveByWebsiteId(website.getWebsiteId(), pageable);

		Response response = new Response();
		response.setMessage("Active products for website");
		response.setData(products.getContent());
		response.setListCount(products.getTotalElements());
		return response;
	}

	@Override
	public void updateProduct(UUID productId, ProductBO productBO) throws Exception {
		Product existing = productRepo.findById(productId)
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Product not found"));

		Website website = websiteRepo.findById(productBO.getWebsiteId())
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));

		existing.setProductName(productBO.getProductName());
		existing.setDescription(productBO.getDescription());
		existing.setPrice(productBO.getPrice());
		existing.setActive(productBO.isActive());
		existing.setWebsite(website);

		productRepo.save(existing);
	}

}
