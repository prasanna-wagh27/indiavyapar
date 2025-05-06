package com.indiavyapar.webservice.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.indiavyapar.webservice.bo.UserBO;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.entity.User;
import com.indiavyapar.webservice.exception.IndiaVyaparException;
import com.indiavyapar.webservice.repository.UserRepository;
import com.indiavyapar.webservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void registerUser(UserBO userBO) throws Exception {

		if(userRepo.findByEmail(userBO.getEmail()).isPresent()) {
			throw new IndiaVyaparException(ErrorConstants.INVALID.toString(), "User with this E-mail is already present. Please Login or use different E-mail to register");
		}
		
		if(userRepo.findByPhoneNumber(userBO.getPhoneNumber()).isPresent()) {
			throw new IndiaVyaparException(ErrorConstants.INVALID.toString(), "User with this Phone Number is already present. Please Login or use different Phone Number");
		}
		
		User user = new User();
		user.setFullName(userBO.getFullName());
		user.setEmail(userBO.getEmail());
		user.setPassword(passwordEncoder.encode(userBO.getPassword())); // Encode password
		user.setPhoneNumber(userBO.getPhoneNumber());
		user.setUserType(userBO.getUserType());
		user.setActive(true);
		
		userRepo.save(user);
	}

	
	
	@Override
	public User getUserById(UUID userId) throws Exception {
		
		User exiUser = userRepo.findById(userId)
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "User not found"));
		return exiUser;
	}



	@Override
	public void updateUser(UUID userId, UserBO userBO) throws Exception {
		User exiUser = getUserById(userId);
		
		if(userBO.getEmail() != exiUser.getEmail() && userRepo.existsByEmail(userBO.getEmail())) {
			throw new IndiaVyaparException(ErrorConstants.INVALID.toString(), "User with this E-mail is already present. Please Login or use different E-mail.");
		}
		
		if(userBO.getPhoneNumber() != exiUser.getPhoneNumber() && userRepo.existsByPhoneNumber(userBO.getPhoneNumber())) {
			throw new IndiaVyaparException(ErrorConstants.INVALID.toString(), "User with this Phone Number is already present. Please Login or use different Phone Number.");
		}
		
		exiUser.setFullName(userBO.getFullName());
		exiUser.setUserType(userBO.getUserType());
		userRepo.save(exiUser);
		
	}
	
	
}
