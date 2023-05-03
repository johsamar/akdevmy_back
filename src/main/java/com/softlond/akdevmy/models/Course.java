package com.softlond.akdevmy.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "Courses")
public class Course {

    @Id
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private ObjectId IdAcademy;


    public Course(){

    }

    public Course(String id, String name, String description, String imageUrl, ObjectId idAcademy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.IdAcademy = idAcademy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ObjectId getIdAcademy() {
        return IdAcademy;
    }

    public void setIdAcademy(ObjectId idAcademy) {
        IdAcademy = idAcademy;
    }
}
