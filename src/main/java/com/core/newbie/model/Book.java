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

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPublishingHouse() {
        return publishing_house;
    }

    public void setPublishingHouse(final String publishing_house) {
        this.publishing_house = publishing_house == null ? null : publishing_house.trim();
    }

    public Integer getTheYearOfPublishing() {
        return the_year_of_publishing;
    }

    public void setTheYearOfPublishing(final Integer the_year_of_publishing) {
        this.the_year_of_publishing = the_year_of_publishing;
    }
    
    public String getCover() {
        return cover;
    }

    public void setCover(final String cover) {
        this.cover = cover == null ? null : cover.trim();
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description == null ? null : description.trim();
    }
}
