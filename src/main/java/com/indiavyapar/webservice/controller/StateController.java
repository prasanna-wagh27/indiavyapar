package com.indiavyapar.webservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.entity.State;
import com.indiavyapar.webservice.service.StateService;

@RestController
@RequestMapping("${url.prefix}/state")
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Response> addState(@RequestBody State state) throws Exception{
		stateService.addState(state);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("State added successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/")
	public ResponseEntity<Response> getAllStates(@SortDefault(sort = "stateName", direction = Direction.ASC) 
	@PageableDefault(page = 0, size = 10) Pageable pageable) throws Exception{
		Response response = stateService.getAllStates(pageable);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("All States List");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/active")
	public ResponseEntity<Response> getActiveStates(@SortDefault(sort = "stateName", direction = Direction.ASC) 
	@PageableDefault(page = 0, size = 10) Pageable pageable) throws Exception{
		Response response = stateService.getActiveStates(pageable);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Active States List");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{stateId")
	public ResponseEntity<Response> getStateById(@PathVariable("stateId") UUID stateId) throws Exception{
		Response response =  new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("State Details");
		response.setData(stateService.getStateById(stateId));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/{stateId}")
	public ResponseEntity<Response> updateState(@PathVariable("stateId") UUID stateId, @RequestBody State state) throws Exception{
		stateService.updateState(stateId, state);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("State updated successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
