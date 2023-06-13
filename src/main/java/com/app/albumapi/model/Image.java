package com.app.albumapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {

	@JsonProperty("albumId")
	private Integer albumId;
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("url")
	private String url;
	@JsonProperty("thumbnailUrl")
	private String thumbnailUrl;
	
	public Image() {
		
	}
	
	public Image(Integer albumId, Integer id, String title, String url, String thumbnailUrl) {
		super();
		this.albumId = albumId;
		this.id = id;
		this.title = title;
		this.url = url;
		this.thumbnailUrl = thumbnailUrl;
	}

	public Integer getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

}
