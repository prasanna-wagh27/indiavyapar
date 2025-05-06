package com.indiavyapar.webservice.entity;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "business_address")
public class BusinessAddress extends Auditable implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "business_address_id")
	@JdbcTypeCode((java.sql.Types.VARCHAR))
	private UUID businessAddressId;
	
	@Column(name = "address_line_one")
    private String addressLineOne;

	@Column(name = "address_line_two")
    private String addressLine2;

	@Column(name = "city")
    private String city;

	@JoinColumn(name = "state_id")
	@ManyToOne(targetEntity = State.class)
	@JdbcTypeCode(java.sql.Types.VARCHAR)
    private State state;
	
	@JoinColumn(name = "district_id")
	@ManyToOne(targetEntity = District.class)
	@JdbcTypeCode(java.sql.Types.VARCHAR)
    private District district;

	@Column(name = "pincode")
    private String pincode;
	
	@Column(name = "google_map_link")
	private String googleMapLink;

	public UUID getBusinessAddressId() {
		return businessAddressId;
	}

	public void setBusinessAddressId(UUID businessAddressId) {
		this.businessAddressId = businessAddressId;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getGoogleMapLink() {
		return googleMapLink;
	}

	public void setGoogleMapLink(String googleMapLink) {
		this.googleMapLink = googleMapLink;
	}
	
	
	
}
