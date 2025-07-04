package com.indiavyapar.webservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.indiavyapar.webservice.bo.GalleryBO;
import com.indiavyapar.webservice.bo.Response;
import com.indiavyapar.webservice.constants.ErrorConstants;
import com.indiavyapar.webservice.entity.Gallery;
import com.indiavyapar.webservice.entity.Website;
import com.indiavyapar.webservice.exception.IndiaVyaparException;
import com.indiavyapar.webservice.repository.GalleryRepository;
import com.indiavyapar.webservice.repository.WebsiteRepository;
import com.indiavyapar.webservice.service.GalleryService;
import com.indiavyapar.webservice.utility.FileUtility;

@Service
public class GalleryServiceImpl implements GalleryService {

	@Autowired
	private GalleryRepository galleryRepo;

	@Autowired
	private WebsiteRepository websiteRepo;

	@Autowired
	private FileUtility fileUtility;

	@Override
	public void uploadImages(UUID websiteId, List<MultipartFile> images) throws Exception {
		Website website = websiteRepo.findById(websiteId)
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));

		List<Gallery> galleryList = new ArrayList<>();

		for (MultipartFile image : images) {

			Gallery gallery = new Gallery();
			gallery.setWebsite(website);
			gallery.setImageUrl(fileUtility.saveImage(image));
			galleryList.add(gallery);
		}

		galleryRepo.saveAll(galleryList);
	}

	@Override
	public void updateGallery(UUID galleryId, GalleryBO galleryBO, MultipartFile image) throws Exception {
		Gallery existing = galleryRepo.findById(galleryId).orElseThrow(
				() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Gallery image not found"));

		Website website = websiteRepo.findById(galleryBO.getWebsiteId())
				.orElseThrow(() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Website not found"));

		existing.setWebsite(website);
		if(null != image) {
			existing.setImageUrl(fileUtility.saveImage(image));
		}
		galleryRepo.save(existing);
	}

	@Override
	public Response getGalleryById(UUID galleryId) throws Exception {
		Gallery gallery = galleryRepo.findById(galleryId).orElseThrow(
				() -> new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString(), "Gallery image not found"));

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
	public void deleteImageById(UUID galleryId) throws Exception {
		if (!galleryRepo.existsById(galleryId)) {
	        throw new IndiaVyaparException(ErrorConstants.NOT_FOUND.toString() ,"Image with ID " + galleryId + " not found.");
	    }
		galleryRepo.deleteById(galleryId);
	}

}
