package com.indiavyapar.webservice.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indiavyapar.webservice.entity.Website;

public interface WebsiteRepository extends JpaRepository<Website, UUID> {

	List<Website> findByUserUserId(UUID userId);

	Optional<Website> findByUrlSlug(String urlSlug);
}
