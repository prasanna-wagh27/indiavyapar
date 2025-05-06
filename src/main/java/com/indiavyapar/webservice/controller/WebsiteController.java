package com.indiavyapar.webservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.dto.WebsiteDTO;
import com.indiavyapar.webservice.entity.BusinessAddress;
import com.indiavyapar.webservice.service.WebsiteService;

@RestController
@RequestMapping("${url.prefix}/website")
public class WebsiteController {
	
	@Autowired
	private WebsiteService websiteService;
	
	@CrossOrigin
	@PostMapping("/business/basic-details")
	public ResponseEntity<Response> saveBasicDetails(@RequestParam("userId") UUID userId, @RequestBody WebsiteDTO websiteDTO)throws Exception{
		Response response = new Response();
		response.setData(websiteService.saveBasicDetails(userId, websiteDTO));
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Details saved successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/business/contact-details")
	public ResponseEntity<Response> saveContactDetails(@RequestParam("websiteId") UUID websiteId, @RequestBody WebsiteDTO websiteDTO)throws Exception{
		websiteService.saveContactDetails(websiteId, websiteDTO);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Contact saved successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("/business/address-details")
	public ResponseEntity<Response> saveAddressDetails(@RequestParam("websiteId") UUID websiteId, @RequestBody BusinessAddress address)throws Exception{
		websiteService.saveAddressDetails(websiteId, address);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Address saved successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/business/other-details")
	public ResponseEntity<Response> saveOtherBusinessDetails(@RequestParam("websiteId") UUID websiteId, @RequestBody WebsiteDTO websiteDTO)throws Exception{
		websiteService.saveOtherBusinessDetails(websiteId, websiteDTO);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Business Details saved successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
