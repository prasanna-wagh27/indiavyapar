package com.indiavyapar.webservice.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.entity.State;
import com.indiavyapar.webservice.exception.IndiaVyaparException;
import com.indiavyapar.webservice.repository.StateRepository;
import com.indiavyapar.webservice.service.StateService;

public class StateServiceImpl implements StateService{
	
	@Autowired
	private StateRepository stateRepo;

	@Override
	public void addState(State state) throws Exception {
		if(stateRepo.existsByStateName(state.getStateName())) {
			throw new IndiaVyaparException(ErrorConstants.INVALID.toString(), "State with this name already exists");
		}
		stateRepo.save(state);
	}

	@Override
	public Response getAllStates(Pageable pageable) throws Exception{
		Response response = new Response();
		Page<State> page = stateRepo.findAll( pageable);
		
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}

	@Override
	public Response getActiveStates(Pageable pageable) throws Exception {
		Response response = new Response();
		Page<State> page = stateRepo.findByStatus(true, pageable);
		
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}

	@Override
	public State getStateById(UUID stateId) throws Exception {
		State exiState = stateRepo.findById(stateId)
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "State not found"));
		return exiState;
	}

	@Override
	public void updateState(UUID stateId, State state) throws Exception {

		State exiState = stateRepo.findById(stateId)
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "State not found"));
		exiState.setStateName(state.getStateName());
		exiState.setStatus(state.getStatus());
		stateRepo.save(exiState);
	}
}