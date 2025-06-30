package com.indiavyapar.webservice.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.entity.District;
import com.indiavyapar.webservice.entity.State;
import com.indiavyapar.webservice.exception.IndiaVyaparException;
import com.indiavyapar.webservice.repository.DistrictRepository;
import com.indiavyapar.webservice.repository.StateRepository;
import com.indiavyapar.webservice.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictRepository districtRepo;

	@Autowired
	private StateRepository stateRepo;

	@Override
	public void addDistrict(District district) throws Exception {
		State exiState = stateRepo.findById(district.getState().getStateId())
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "State not found"));
		if (districtRepo.existsByStateAndDistrictName(exiState, district.getDistrictName())) {
			throw new IndiaVyaparException(ErrorConstants.INVALID.toString(), "District with this name already exists");
		}
		district.setState(exiState);
		districtRepo.save(district);
	}

	@Override
	public Response getAllDistrictsByState(UUID stateId, Pageable pageable) throws Exception {
		Response response = new Response();
		Page<District> page = districtRepo.getAllDistrictsByState(stateId, pageable);
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}

	@Override
	public Response getActiveDistricts(UUID stateId, Pageable pageable) throws Exception {
		Response response = new Response();
		Page<District> page = districtRepo.getActiveDistricts(stateId, pageable);
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}

	@Override
	public District getDistrictById(UUID districtId) throws Exception {
		return districtRepo.findById(districtId)
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Invalid stateId"));
	}

	@Override
	public void updateDistrict(UUID districtId, District district) throws Exception {
		District exiDistrict = getDistrictById(districtId);
		State exiState = stateRepo.findById(district.getState().getStateId())
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "State not found"));

		if (districtRepo.existsByStateAndDistrictName(exiState, district.getDistrictName())
				&& !district.getDistrictName().equals(exiDistrict.getDistrictName())) {
			throw new IndiaVyaparException(ErrorConstants.INVALID.toString(), "District with this name already exists");
		}
		exiDistrict.setDistrictName(district.getDistrictName());
		exiDistrict.setState(district.getState());
		exiDistrict.setStatus(district.getStatus());
		districtRepo.save(exiDistrict);
	}

}
