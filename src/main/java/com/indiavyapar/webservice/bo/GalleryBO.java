package com.indiavyapar.webservice.bo;

import java.util.UUID;

public class GalleryBO {

	private UUID websiteId;
	private String imageUrl;
	private boolean isActive;
	public UUID getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(UUID websiteId) {
		this.websiteId = websiteId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
