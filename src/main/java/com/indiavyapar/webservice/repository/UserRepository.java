package com.indiavyapar.webservice.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indiavyapar.webservice.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {

	Optional<User> findByEmail(String email);

	Optional<User> findByPhoneNumber(String phoneNumber);

	boolean existsByEmail(String email);

	boolean existsByPhoneNumber(String phoneNumber);

}
