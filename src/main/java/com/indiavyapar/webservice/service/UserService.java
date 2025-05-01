package com.indiavyapar.webservice.service;

import java.util.UUID;

import com.indiavyapar.webservice.bo.UserBO;
import com.indiavyapar.webservice.entity.User;

public interface UserService {

	void registerUser(UserBO userBO) throws Exception;

	User getUserById(UUID userId) throws Exception;

	void updateUser(UUID userId, UserBO userBO) throws Exception;

}
