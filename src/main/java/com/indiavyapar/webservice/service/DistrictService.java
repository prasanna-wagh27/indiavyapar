package com.indiavyapar.webservice.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.entity.District;

public interface DistrictService {
	
	void addDistrict(District district) throws Exception;

	Response getAllDistrictsByState(UUID stateId, Pageable pageable) throws Exception;

	Response getActiveDistricts(UUID stateId, Pageable pageable) throws Exception;

	District getDistrictById(UUID districtId) throws Exception;

	void updateDistrict(UUID districtId, District district) throws Exception;


}
