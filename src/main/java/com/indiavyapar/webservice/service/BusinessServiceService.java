package com.indiavyapar.webservice.service;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.indiavyapar.webservice.bo.BusinessServiceBO;
import com.indiavyapar.webservice.bo.Response;

public interface BusinessServiceService {
	
	void createService(BusinessServiceBO serviceBO, MultipartFile file) throws Exception;

    void updateService(UUID serviceId, BusinessServiceBO serviceBO, MultipartFile image) throws Exception;

    Response getServiceById(UUID serviceId) throws Exception;

    Response getServicesByWebsiteId(UUID websiteId) throws Exception;

}
