package com.indiavyapar.webservice.service;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.indiavyapar.webservice.dto.WebsiteDTO;
import com.indiavyapar.webservice.entity.BusinessAddress;

public interface WebsiteService {
	
	UUID saveBasicDetails(MultipartFile file, WebsiteDTO websiteDTO) throws Exception;

	void saveContactDetails(UUID websiteId, WebsiteDTO websiteDTO) throws Exception;

	void saveAddressDetails(UUID websiteId, BusinessAddress address) throws Exception;

	void saveOtherBusinessDetails(UUID websiteId, WebsiteDTO websiteDTO) throws Exception;

}
