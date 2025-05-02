package com.indiavyapar.webservice.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.entity.State;

public interface StateService {

	void addState(State state) throws Exception;

	Response getAllStates(Pageable pageable) throws Exception;

	Response getActiveStates(Pageable pageable) throws Exception;

	State getStateById(UUID stateId) throws Exception;

	void updateState(UUID stateId, State state) throws Exception;

}
