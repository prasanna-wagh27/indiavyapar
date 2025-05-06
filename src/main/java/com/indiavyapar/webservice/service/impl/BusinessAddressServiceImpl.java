package com.indiavyapar.webservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indiavyapar.webservice.entity.BusinessAddress;
import com.indiavyapar.webservice.repository.BusinessAddressRepository;
import com.indiavyapar.webservice.service.BusinessAddressService;

@Service
public class BusinessAddressServiceImpl implements BusinessAddressService{
	
	@Autowired
	private BusinessAddressRepository businessAddressRepository;

	@Override
	public BusinessAddress saveBusinessAddress(BusinessAddress address) throws Exception {
		
		if (address.getAddressLineOne() == null || address.getAddressLineOne().isBlank()) {
	        throw new IllegalArgumentException("Address Line One is required.");
	    }

	    if (address.getState() == null || address.getState().getStateId() == null) {
	        throw new IllegalArgumentException("State is required.");
	    }

	    if (address.getDistrict() == null || address.getDistrict().getDistrictId() == null) {
	        throw new IllegalArgumentException("District is required.");
	    }

	    if (address.getPincode() == null || address.getPincode().isBlank()) {
	        throw new IllegalArgumentException("Pincode is required.");
	    }
	    
	    BusinessAddress savedAddress = businessAddressRepository.save(address);
	    
	    return savedAddress;
	    
		
	}

}
