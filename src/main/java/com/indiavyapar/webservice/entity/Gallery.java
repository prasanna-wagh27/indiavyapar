package com.indiavyapar.webservice.entity;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gallery")
public class Gallery extends Auditable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	@Column(name = "gallery_id")
	private UUID galleryId;
	
	@JoinColumn(name = "website_id")
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	@ManyToOne(targetEntity = Website.class)
	private Website website;

	@Column(name = "image_url")
	private String imageUrl;

	public UUID getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(UUID galleryId) {
		this.galleryId = galleryId;
	}

	public Website getWebsite() {
		return website;
	}

	public void setWebsite(Website website) {
		this.website = website;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
