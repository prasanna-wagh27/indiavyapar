package com.indiavyapar.webservice.bo;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductBO {
	
	private UUID websiteId;
    private String productName;
    private String description;
    private BigDecimal price;
    private boolean isActive;
    private List<String> imageUrls;
    
	public UUID getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(UUID websiteId) {
		this.websiteId = websiteId;
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public List<String> getImageUrls() {
		return imageUrls;
	}
	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	} 
    
    

}
