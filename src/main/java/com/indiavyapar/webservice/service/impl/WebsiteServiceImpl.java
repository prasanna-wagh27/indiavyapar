package com.indiavyapar.webservice.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.dto.WebsiteDTO;
import com.indiavyapar.webservice.entity.BusinessAddress;
import com.indiavyapar.webservice.entity.User;
import com.indiavyapar.webservice.entity.Website;
import com.indiavyapar.webservice.exception.IndiaVyaparException;
import com.indiavyapar.webservice.repository.UserRepository;
import com.indiavyapar.webservice.repository.WebsiteRepository;
import com.indiavyapar.webservice.service.BusinessAddressService;
import com.indiavyapar.webservice.service.WebsiteService;

@Service
public class WebsiteServiceImpl implements WebsiteService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private WebsiteRepository websiteRepository;

	@Autowired
	private BusinessAddressService businessAddressService;

	@Override
	public UUID saveBasicDetails(UUID userId, WebsiteDTO websiteDTO) throws Exception {
		
		User exiUser = userRepository.findById(userId)
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "User not found")) 	;
		
		Website website = new Website();
		website.setBusinessName(websiteDTO.getBusinessName());
		website.setSlogan(websiteDTO.getSlogan());

		// Logo
		website.setBusinessType(websiteDTO.getBusinessType());
		
		website.setUser(exiUser);
		websiteRepository.save(website);
		return website.getWebsiteId();

	}

	@Override
	public void saveContactDetails(UUID websiteId, WebsiteDTO websiteDTO) throws Exception {
		Website exiWebsite = websiteRepository.findById(websiteId)
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));

		exiWebsite.setPhoneNumber(websiteDTO.getPhoneNumber());
		exiWebsite.setEmail(websiteDTO.getEmail());

		if (websiteDTO.getWhatsappNumber() != null) {
			exiWebsite.setWhatsappNumber(websiteDTO.getWhatsappNumber());
		}

		if (websiteDTO.getFacebookLink() != null) {
			exiWebsite.setFacebookLink(websiteDTO.getFacebookLink());
		}

		if (websiteDTO.getInstagramLink() != null) {
			exiWebsite.setInstagramLink(websiteDTO.getInstagramLink());
		}

		if (websiteDTO.getxLink() != null) {
			exiWebsite.setxLink(websiteDTO.getxLink());
		}

		websiteRepository.save(exiWebsite);
	}

	@Override
	public void saveAddressDetails(UUID websiteId, BusinessAddress address) throws Exception {
		Website exiWebsite = websiteRepository.findById(websiteId)
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));
		if (address.getGoogleMapLink() == null) {
			exiWebsite.setGoogleMapLink(address.getGoogleMapLink());
		}

		BusinessAddress savedAddress = businessAddressService.saveBusinessAddress(address);

		exiWebsite.setBusinessAddress(savedAddress);

		websiteRepository.save(exiWebsite);
	}

	@Override
	public void saveOtherBusinessDetails(UUID websiteId, WebsiteDTO websiteDTO) throws Exception {
		Website exiWebsite = websiteRepository.findById(websiteId)
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));
		
		exiWebsite.setYearOfEstablishment(websiteDTO.getYearOfEstablishment());
		exiWebsite.setAboutUs(websiteDTO.getAboutUs());
		exiWebsite.setSpecialisations(websiteDTO.getSpecialisations());
		websiteRepository.save(exiWebsite);
	}

}
