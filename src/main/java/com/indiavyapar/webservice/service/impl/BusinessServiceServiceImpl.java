package com.indiavyapar.webservice.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indiavyapar.webservice.bo.BusinessServiceBO;
import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.entity.BusinessService;
import com.indiavyapar.webservice.entity.Website;
import com.indiavyapar.webservice.exception.IndiaVyaparException;
import com.indiavyapar.webservice.repository.BusinessServiceRepository;
import com.indiavyapar.webservice.repository.WebsiteRepository;
import com.indiavyapar.webservice.service.BusinessServiceService;

@Service
public class BusinessServiceServiceImpl implements BusinessServiceService {

    @Autowired
    private BusinessServiceRepository serviceRepo;

    @Autowired
    private WebsiteRepository websiteRepo;

    @Override
    public void createService(BusinessServiceBO serviceBO) throws Exception {
        Website website = websiteRepo.findById(serviceBO.getWebsiteId())
                .orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));

        BusinessService service = new BusinessService();
        service.setWebsite(website);
        service.setServiceName(serviceBO.getServiceName());
        service.setServiceDescription(serviceBO.getServiceDescription());
        service.setPrice(serviceBO.getPrice());
        service.setServiceImageUrl(serviceBO.getServiceImageUrl());

        serviceRepo.save(service);
    }

    @Override
    public void updateService(UUID serviceId, BusinessServiceBO serviceBO) throws Exception {
        BusinessService existing = serviceRepo.findById(serviceId)
                .orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Service not found"));

        Website website = websiteRepo.findById(serviceBO.getWebsiteId())
                .orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));

        existing.setWebsite(website);
        existing.setServiceName(serviceBO.getServiceName());
        existing.setServiceDescription(serviceBO.getServiceDescription());
        existing.setPrice(serviceBO.getPrice());
        existing.setServiceImageUrl(serviceBO.getServiceImageUrl());

        serviceRepo.save(existing);
    }

	@Override
    public Response getServiceById(UUID serviceId) throws Exception {
        BusinessService service = serviceRepo.findById(serviceId)
                .orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Service not found"));

        Response response = new Response();
        response.setMessage("Service details");
        response.setData(service);
        return response;
    }

    @Override
    public Response getServicesByWebsiteId(UUID websiteId) throws Exception {
        List<BusinessService> services = serviceRepo.findAllByWebsiteId(websiteId);

        Response response = new Response();
        response.setMessage("Services for website");
        response.setData(services);
        return response;
    }
}
