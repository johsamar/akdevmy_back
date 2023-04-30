package com.softlond.akdevmy.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Class {
	@Id
	private ObjectId _id;
	private String type;
	private String name;
	private String description;
	private Integer duration;
	private String url;
	private String image;
	private String video;
	private String document;
	private Integer position;
	
	public Class() {}

	public Class(ObjectId _id, String type, String name, String description, Integer duration, String url, String image,
			String video, String document, Integer position) {
		super();
		this._id = _id;
		this.type = type;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.url = url;
		this.image = image;
		this.video = video;
		this.document = document;
		this.position = position;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

}
