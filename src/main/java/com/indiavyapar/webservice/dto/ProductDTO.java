package com.indiavyapar.webservice.dto;

import java.util.List;
import java.util.UUID;

public class ProductDTO {

	private UUID productId;
    private String productName;
    private String description;
    private double price;
    private boolean active;
    private UUID websiteId;
    private List<String> imageUrls;
    
	public UUID getProductId() {
		return productId;
	}
	public void setProductId(UUID productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public UUID getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(UUID websiteId) {
		this.websiteId = websiteId;
	}
	public List<String> getImageUrls() {
		return imageUrls;
	}
	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}
    
    
    
}
