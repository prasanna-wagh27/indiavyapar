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
@Table(name = "feedback")
public class Feedback extends Auditable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "feedback_id")
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private UUID feedbackId;
	
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	@JoinColumn(name = "website_id")
	@ManyToOne(targetEntity = Website.class)
	private Website website;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "comment", columnDefinition = "LONGTEXT")
	private String comment;
	
	@Column(name = "rating")
	private int rating;

	public UUID getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(UUID feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Website getWebsite() {
		return website;
	}

	public void setWebsite(Website website) {
		this.website = website;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	

}
