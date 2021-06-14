package com.Main.Models;

import com.Main.Models.Referentiel.Category;
import com.Main.Security.AppUser;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="AEM_AdEntityModel")
public class AdsEntityModel {
    public AdsEntityModel(long id, String title, Date creationDate, String objectLocation, boolean isDeleted, String details, double price, String targetNumber, List<AdDescription> descriptions, List<AdPictures> pictures, Category category, AppUser user) {
        Id = id;
        this.title = title;
        this.creationDate = creationDate;
        this.objectLocation = objectLocation;
        this.isDeleted = isDeleted;
        this.details = details;
        this.price = price;
        this.targetNumber = targetNumber;
        this.descriptions = descriptions;
        this.pictures = pictures;
        this.category = category;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String title; //Titre
    private Date creationDate;
    private String objectLocation;
    private boolean isDeleted;
    private String details;
    private double price;
    private String targetNumber;

    @OneToOne()
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    private Category category;

    @OneToOne()
    @JoinColumn(name = "ownerId", referencedColumnName = "id")
    private AppUser user;


    @OneToMany(targetEntity = AdDescription.class, cascade = CascadeType.ALL)
    @JoinColumn(name="AdsId", referencedColumnName = "id")
    private List<AdDescription> descriptions;

    @OneToMany(targetEntity = AdPictures.class, cascade = CascadeType.ALL)
    @JoinColumn(name="AdsPId", referencedColumnName = "id")
    private List<AdPictures> pictures;



    public List<AdDescription> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<AdDescription> descriptions) {
        this.descriptions = descriptions;
    }

    public AdsEntityModel(){}

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getObjectLocation() {
        return objectLocation;
    }

    public void setObjectLocation(String objectLocation) {
        this.objectLocation = objectLocation;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(String targetNumber) {
        this.targetNumber = targetNumber;
    }

    public List<AdPictures> getPictures() {
        return pictures;
    }

    public void setPictures(List<AdPictures> pictures) {
        this.pictures = pictures;
    }

    public Category getCategory() {
        return category;
    }

    public AppUser getUser() {
        return user;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setUser(AppUser user) {this.user = user;}
}
