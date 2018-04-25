package com.core.newbie.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    private Integer id;

    private String name;

    private String author;

    private String publishing_house;

    private Integer the_year_of_publishing;

    private String cover;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishing_house;
    }

    public void setPublishingHouse(String publishing_house) {
        this.publishing_house = publishing_house;
    }

    public Integer getTheYearOfPublishing() {
        return the_year_of_publishing;
    }

    public void setTheYearOfPublishing(Integer the_year_of_publishing) {
        this.the_year_of_publishing = the_year_of_publishing;
    }
    
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
