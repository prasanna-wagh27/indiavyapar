package com.indiavyapar.webservice.entity;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import com.indiavyapar.webservice.constants.BusinessType;
import com.indiavyapar.webservice.constants.WebsiteStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "website")
public class Website extends Auditable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "website_id", updatable = false, nullable = false)
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private UUID websiteId;
	
	@JoinColumn(name = "user_id")
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	@ManyToOne(targetEntity = User.class)
	private User user;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "subtitle")
	private String subtitle;
	
	@Column(name = "about_us", columnDefinition = "LONGTEXT")
	private String aboutUs;
	
	@Column(name = "template_id")
	private String templateId;
	
	@Column(name = "url_slug")
	private String urlSlug;
	
	@Column(name = "company_name")
	private String companyName;

	@Column(name = "category")
    private String category;

	@Column(name = "year_of_establishment")
    private String yearOfEstablishment;

	@Column(name = "nature_of_business")
    private String natureOfBusiness;
    
	@Column(name = "address_line_one")
    private String addressLineOne;

	@Column(name = "address_line_two")
    private String addressLine2;

	@Column(name = "city")
    private String city;

	@Column(name = "state")
    private String state;

	@Column(name = "pincode")
    private String pincode;

	@Column(name = "google_map_link")
    private String googleMapLink;

	@Column(name = "phone_number")
    private String phoneNumber;

	@Column(name = "whatsapp_number")
    private String whatsappNumber;

	@Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "website_status")
    private WebsiteStatus websiteStatus;

    @Column(name = "brochure_url")
    private String brochureUrl;
    
    @Column(name = "business_type")
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

	public UUID getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(UUID websiteId) {
		this.websiteId = websiteId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getYearOfEstablishment() {
		return yearOfEstablishment;
	}

	public void setYearOfEstablishment(String yearOfEstablishment) {
		this.yearOfEstablishment = yearOfEstablishment;
	}

	public String getNatureOfBusiness() {
		return natureOfBusiness;
	}

	public void setNatureOfBusiness(String natureOfBusiness) {
		this.natureOfBusiness = natureOfBusiness;
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

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}


	
}
