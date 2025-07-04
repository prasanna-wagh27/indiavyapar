package com.indiavyapar.webservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.indiavyapar.webservice.bo.BusinessServiceBO;
import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.service.BusinessServiceService;

@RestController
@RequestMapping("${url.prefix}/business-service")
public class BusinessServiceController {

    @Autowired
    private BusinessServiceService businessServiceService;

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Response> createBusinessService(@RequestPart("serviceBO") BusinessServiceBO serviceBO,
    		@RequestPart("image") MultipartFile file) throws Exception {
        businessServiceService.createService(serviceBO, file);
        Response response = new Response();
        response.setStatus(ErrorConstants.SUCCESS.toString());
        response.setMessage("Business service created successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateBusinessService(@PathVariable UUID id, 
    		@RequestPart("serviceBO") BusinessServiceBO serviceBO,
    		@RequestPart(value = "image", required = false) MultipartFile image) throws Exception {
        businessServiceService.updateService(id, serviceBO, image);
        Response response = new Response();
        response.setStatus(ErrorConstants.SUCCESS.toString());
        response.setMessage("Business service updated successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Response> getBusinessServiceById(@PathVariable UUID id) throws Exception {
        Response response = businessServiceService.getServiceById(id);
        response.setStatus(ErrorConstants.SUCCESS.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/website/{websiteId}")
    public ResponseEntity<Response> getServicesByWebsite(@PathVariable UUID websiteId) throws Exception {
        Response response = businessServiceService.getServicesByWebsiteId(websiteId);
        response.setStatus(ErrorConstants.SUCCESS.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}