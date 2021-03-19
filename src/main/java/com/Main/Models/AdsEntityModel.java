package com.Main.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="AEM_AdEntityModel")
public class AdsEntityModel {
    public AdsEntityModel(long id, String title, Date creationDate, String objectLocation, boolean isDeleted, String details, double price, String targetNumber) {
        Id = id;
        this.title = title;
        this.creationDate = creationDate;
        this.objectLocation = objectLocation;
        this.isDeleted = isDeleted;
        this.details = details;
        this.price = price;
        this.targetNumber = targetNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String title;
    private Date creationDate;
    private String objectLocation;
    private boolean isDeleted;
    private String details;
    private double price;
    private String targetNumber;

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
}
