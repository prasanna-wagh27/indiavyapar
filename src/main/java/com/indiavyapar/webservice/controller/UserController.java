package com.indiavyapar.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.bo.UserBO;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.service.UserService;

@RestController
@RequestMapping("${url.prefix}/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Response> addUser(UserBO userBO) throws Exception{
		userService.addUser(userBO);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("You have been registered successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

}
