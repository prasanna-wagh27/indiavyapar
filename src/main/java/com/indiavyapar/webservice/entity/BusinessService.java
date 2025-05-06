package com.indiavyapar.webservice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "business_service")
public class BusinessService extends Auditable implements Serializable{
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	@JdbcTypeCode(java.sql.Types.VARCHAR)
    @Column(name = "business_service_id")
    private UUID businessServiceId;

    @JoinColumn(name = "website_id")
    @ManyToOne(targetEntity = Website.class)
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private Website website;

    @Column(name = "service_name", nullable = false, length = 255)
    private String serviceName;

    @Column(name = "service_description", columnDefinition = "LONGTEXT")
    private String serviceDescription;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "service_image_url", length = 512)
    private String serviceImageUrl;


	public UUID getBusinessServiceId() {
		return businessServiceId;
	}

	public void setBusinessServiceId(UUID businessServiceId) {
		this.businessServiceId = businessServiceId;
	}

	public Website getWebsite() {
		return website;
	}

	public void setWebsite(Website website) {
		this.website = website;
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
