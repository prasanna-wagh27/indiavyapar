package com.indiavyapar.webservice.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indiavyapar.webservice.bo.ProductBO;
import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.entity.Product;
import com.indiavyapar.webservice.entity.Website;
import com.indiavyapar.webservice.exception.IndiaVyaparException;
import com.indiavyapar.webservice.repository.ProductRepository;
import com.indiavyapar.webservice.repository.WebsiteRepository;
import com.indiavyapar.webservice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
    private ProductRepository productRepo;

    @Autowired
    private WebsiteRepository websiteRepo;

    @Override
    public void createProduct(ProductBO productBO) throws Exception {
        Website website = websiteRepo.findById(productBO.getWebsiteId())
                .orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));

        Product product = new Product();
        product.setProductName(productBO.getProductName());
        product.setDescription(productBO.getDescription());
        product.setPrice(productBO.getPrice());
        product.setActive(productBO.isActive());
        product.setWebsite(website);

        productRepo.save(product);
    }

    @Override
    public Response getProductById(UUID productId) throws Exception {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Product not found"));

        Response response = new Response();
        response.setMessage("Product details");
        response.setData(product);
        return response;
    }

}
