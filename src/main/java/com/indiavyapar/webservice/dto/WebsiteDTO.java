package com.indiavyapar.webservice.dto;

import java.util.UUID;

import com.indiavyapar.webservice.constants.BusinessCategory;
import com.indiavyapar.webservice.constants.BusinessType;
import com.indiavyapar.webservice.constants.WebsiteStatus;

public class WebsiteDTO {

	private UUID websiteId;
	private UUID userId;
	private String title;
	private String slogan;
	private String aboutUs;
	private String templateId;
	private String urlSlug;
	private String businessName;
	private String yearOfEstablishment;
	private BusinessType businessType;
	private String addressLineOne;
	private String addressLine2;
	private String city;
	private String state;
	private String pincode;
	private String googleMapLink;
	private String phoneNumber;
	private String whatsappNumber;
	private String email;
	private WebsiteStatus websiteStatus;
	private String brochureUrl;
	private BusinessCategory businessCategory;
	public String facebookLink;
	public String instagramLink;
	public String xLink;
	private String specialisations;
	private String natureOfBusiness;

	public UUID getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(UUID websiteId) {
		this.websiteId = websiteId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getAboutUs() {
		return aboutUs;
	}

	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getUrlSlug() {
		return urlSlug;
	}

	public void setUrlSlug(String urlSlug) {
		this.urlSlug = urlSlug;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getYearOfEstablishment() {
		return yearOfEstablishment;
	}

	public void setYearOfEstablishment(String yearOfEstablishment) {
		this.yearOfEstablishment = yearOfEstablishment;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWhatsappNumber() {
		return whatsappNumber;
	}

	public void setWhatsappNumber(String whatsappNumber) {
		this.whatsappNumber = whatsappNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public WebsiteStatus getWebsiteStatus() {
		return websiteStatus;
	}

	public void setWebsiteStatus(WebsiteStatus websiteStatus) {
		this.websiteStatus = websiteStatus;
	}

	public String getBrochureUrl() {
		return brochureUrl;
	}

	public void setBrochureUrl(String brochureUrl) {
		this.brochureUrl = brochureUrl;
	}

	public BusinessCategory getBusinessCategory() {
		return businessCategory;
	}

	public void setBusinessCategory(BusinessCategory businessCategory) {
		this.businessCategory = businessCategory;
	}

	public String getFacebookLink() {
		return facebookLink;
	}

	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}

	public String getInstagramLink() {
		return instagramLink;
	}

	public void setInstagramLink(String instagramLink) {
		this.instagramLink = instagramLink;
	}

	public String getxLink() {
		return xLink;
	}

	public void setxLink(String xLink) {
		this.xLink = xLink;
	}

	public String getSpecialisations() {
		return specialisations;
	}

	public void setSpecialisations(String specialisations) {
		this.specialisations = specialisations;
	}

	public String getNatureOfBusiness() {
		return natureOfBusiness;
	}

	public void setNatureOfBusiness(String natureOfBusiness) {
		this.natureOfBusiness = natureOfBusiness;
	}
	
}
