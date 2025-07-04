package com.indiavyapar.webservice.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.indiavyapar.webservice.entity.Gallery;
import com.indiavyapar.webservice.entity.Website;

public interface GalleryRepository extends JpaRepository<Gallery, UUID> {

	Page<Gallery> findAllByWebsite(Website website, Pageable pageable);
}
