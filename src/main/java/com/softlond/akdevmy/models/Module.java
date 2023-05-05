package com.softlond.akdevmy.models;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Modules")
public class Module {

	@Id
	private String _id;
	private String name;
	private String description;
	private List<Class> classes;
	private ObjectId idCourse;
	
	public Module() {
		this.classes = new ArrayList<Class>();
	}

	public Module(String _id, String name, String description, List<Class> classes, ObjectId idCourse) {
		super();
		this._id = _id;
		this.name = name;
		this.description = description;
		this.classes = classes;
		this.idCourse = idCourse;		
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

	public String getIdCourse() {
		return idCourse.toString();
	}

	public void setIdCourse(ObjectId idCourse) {
		this.idCourse = idCourse;
	}

}
