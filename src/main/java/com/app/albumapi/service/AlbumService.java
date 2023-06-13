package com.app.albumapi.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.albumapi.model.Image;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AlbumService {

	AlbumService(){
		
	}
	
	public List<Image> getImageList(String urlToRead) throws Exception {
	      StringBuilder result = new StringBuilder();
	      URL url = new URL(urlToRead);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      try (BufferedReader reader = new BufferedReader(
	                  new InputStreamReader(conn.getInputStream()))) {
	          for (String line; (line = reader.readLine()) != null; ) {
	              result.append(line);
	          }
	      }
	      ObjectMapper objectMapper = new ObjectMapper();
	     return objectMapper.readValue(result.toString(), new TypeReference<List<Image>>(){});
	      
	   }
	
	
}
