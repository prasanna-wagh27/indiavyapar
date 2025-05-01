package com.indiavyapar.webservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@PostMapping("/register")
	public ResponseEntity<Response> registerUser(UserBO userBO) throws Exception{
		userService.registerUser(userBO);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("You have been registered successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	@CrossOrigin
	@GetMapping("/{userId}")
	public ResponseEntity<Response> getUserById(@PathVariable("userId") UUID userId) throws Exception{
		userService.getUserById(userId);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("User profile");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/update/{userId}")
	public ResponseEntity<Response> updateUser(@PathVariable("userId") UUID userId ,UserBO userBO) throws Exception{
		userService.updateUser(userId, userBO);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Your profile has been updated successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

}
