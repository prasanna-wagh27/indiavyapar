package com.indiavyapar.webservice.bo;

import java.math.BigDecimal;
import java.util.UUID;

public class BusinessServiceBO {

	private UUID websiteId;
	private String serviceName;
	private String serviceDescription;
	private BigDecimal price;
	private String serviceImageUrl;
	public UUID getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(UUID websiteId) {
		this.websiteId = websiteId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getServiceImageUrl() {
		return serviceImageUrl;
	}
	public void setServiceImageUrl(String serviceImageUrl) {
		this.serviceImageUrl = serviceImageUrl;
	}
	
	

}
