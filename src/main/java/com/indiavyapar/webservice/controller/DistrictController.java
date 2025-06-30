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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.entity.District;
import com.indiavyapar.webservice.service.DistrictService;

@RestController
@RequestMapping("${url.prefix}/district")
public class DistrictController {

	@Autowired
	private DistrictService districtService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Response> addDistrict(@RequestBody District district) throws Exception{
		districtService.addDistrict(district);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("District added successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<Response> getAllDistrictsByState(@RequestParam(name = "stateId", required = false) UUID stateId,
			@SortDefault(sort = "name", direction = Direction.ASC) 
	@PageableDefault(page = 0, size = 10) Pageable pageable) throws Exception{
		Response response = districtService.getAllDistrictsByState(stateId, pageable);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("All Districts List");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/active")
	public ResponseEntity<Response> getActiveDistrictsByState(@RequestParam(name = "stateId", required = false) UUID stateId,
			@SortDefault(sort = "districtName", direction = Direction.ASC) 
	@PageableDefault(page = 0, size = 10) Pageable pageable) throws Exception{
		Response response = districtService.getActiveDistricts(stateId, pageable);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Active Districts List");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{districtId}")
	public ResponseEntity<Response> getDistrictById(@PathVariable("districtId") UUID districtId) throws Exception{
		Response response =  new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("District Details");
		response.setData(districtService.getDistrictById(districtId));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/{districtId}")
	public ResponseEntity<Response> updateDistrict(@PathVariable("districtId") UUID districtId, @RequestBody District district) throws Exception{
		districtService.updateDistrict(districtId, district);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("District updated successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
}
