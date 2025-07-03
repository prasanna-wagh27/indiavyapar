package com.indiavyapar.webservice.entity;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_image")
public class ProductImage extends Auditable implements Serializable{

	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.UUID)
		@JdbcTypeCode(java.sql.Types.VARCHAR)
		@Column(name = "product_image_id")
	    private UUID productImageId;

	 	@Column(name = "image")
	    private String imageUrl;

	    @JdbcTypeCode(java.sql.Types.VARCHAR)
	    @JoinColumn(name = "product_id")
	    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
	    @JsonIgnore
	    private Product product;

		public UUID getProductImageId() {
			return productImageId;
		}

		public void setProductImageId(UUID productImageId) {
			this.productImageId = productImageId;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}
}
