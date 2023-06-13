package com.app.albumapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.albumapi.model.Image;
import com.app.albumapi.service.AlbumService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping
@AllArgsConstructor
@CrossOrigin("*")
public class AlbumController {
	
	@Autowired
	AlbumService albumService;
	
	private final String IMAGE_LIBRARY = "https://jsonplaceholder.typicode.com/photos";

	AlbumController() {
	}
	
	@GetMapping("/findAlbumByIdNumber")
	public List<Image> findAlbumByIdNumber(@RequestHeader String albumIdNumber) throws Exception {

		List<Image> images = albumService.getImageList(IMAGE_LIBRARY + "?albumId=" + albumIdNumber);
		if(images.size() == 0) {
			throw new Exception("Invalid Query, please query via albumId number, ie: '3' or '5'");
		}
		return images;
	}
	@GetMapping("/findImagesByTitle")
	public List<Image> findImagesByTitle(@RequestHeader String titleQuery) throws Exception {

		List<Image> images = albumService.getImageList(IMAGE_LIBRARY);
		List<Image> refinedImages = new ArrayList<Image>();
		for(Image i : images) {
			if(i.getTitle().contains(titleQuery)) {
				refinedImages.add(i);
			}
		}
		if(refinedImages.size() == 0) {
			throw new Exception("No images containing the query: " + titleQuery + " were found");
		}
		return refinedImages;
	}
	@GetMapping("/findImageById")
	public Image findImageById(@RequestHeader String id) throws Exception {

		List<Image> images = albumService.getImageList(IMAGE_LIBRARY);
		for(Image i : images) {
			if(i.getId().equals(Integer.valueOf(id))) {
				return i;
			}
		}
		throw new Exception("Query not found");
	}
	
}