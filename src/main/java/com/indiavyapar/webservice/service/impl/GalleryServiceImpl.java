package com.indiavyapar.webservice.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.indiavyapar.webservice.bo.GalleryBO;
import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.entity.Gallery;
import com.indiavyapar.webservice.entity.Website;
import com.indiavyapar.webservice.exception.IndiaVyaparException;
import com.indiavyapar.webservice.repository.GalleryRepository;
import com.indiavyapar.webservice.repository.WebsiteRepository;
import com.indiavyapar.webservice.service.GalleryService;

@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryRepository galleryRepo;

    @Autowired
    private WebsiteRepository websiteRepo;

    @Override
    public void createGallery(GalleryBO galleryBO) throws Exception {
        Website website = websiteRepo.findById(galleryBO.getWebsiteId())
                .orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));

        Gallery gallery = new Gallery();
        gallery.setWebsite(website);
        gallery.setImageUrl(galleryBO.getImageUrl());
        gallery.setActive(galleryBO.isActive());

        galleryRepo.save(gallery);
    }

    @Override
    public void updateGallery(UUID galleryId, GalleryBO galleryBO) throws Exception {
        Gallery existing = galleryRepo.findById(galleryId)
                .orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Gallery image not found"));

        Website website = websiteRepo.findById(galleryBO.getWebsiteId())
                .orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));

        existing.setWebsite(website);
        existing.setImageUrl(galleryBO.getImageUrl());
        existing.setActive(galleryBO.isActive());

        galleryRepo.save(existing);
    }

    @Override
    public Response getGalleryById(UUID galleryId) throws Exception {
        Gallery gallery = galleryRepo.findById(galleryId)
                .orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Gallery image not found"));

        Response response = new Response();
        response.setMessage("Gallery image details");
        response.setData(gallery);
        return response;
    }

    @Override
    public Response getAllGalleryByWebsite(UUID websiteId, Pageable pageable) throws Exception {
        Website website = websiteRepo.findById(websiteId)
                .orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));

        Page<Gallery> galleryList = galleryRepo.findAllByWebsite(website, pageable);

        Response response = new Response();
        response.setMessage("Gallery images for website");
        response.setData(galleryList.getContent());
		response.setListCount(galleryList.getTotalElements());
        return response;
    }

    @Override
    public Response getActiveGalleryByWebsite(UUID websiteId, Pageable pageable) throws Exception {
        Website website = websiteRepo.findById(websiteId)
                .orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));

        Page<Gallery> galleryList = galleryRepo.findAllByWebsiteAndIsActiveTrue(website, pageable);

        Response response = new Response();
        response.setMessage("Active gallery images for website");
        response.setData(galleryList.getContent());
		response.setListCount(galleryList.getTotalElements());
        return response;
    }
}
