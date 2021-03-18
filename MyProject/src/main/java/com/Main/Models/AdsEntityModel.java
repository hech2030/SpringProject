package com.Main.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="AEM_AdEntityModel")
public class AdsEntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Title;
    private Date CreationDate;
    private String ObjectLocation;
    private boolean IsDeleted;
    private String Details;
    private double Price;
    private String TargetNumber;

    public AdsEntityModel(){}

    public AdsEntityModel(long id, String title, Date creationDate, String objectLocation, boolean isDeleted, String details, double price, String targetNumber) {
        Id = id;
        Title = title;
        CreationDate = creationDate;
        ObjectLocation = objectLocation;
        IsDeleted = isDeleted;
        Details = details;
        Price = price;
        TargetNumber = targetNumber;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }

    public String getObjectLocation() {
        return ObjectLocation;
    }

    public void setObjectLocation(String objectLocation) {
        ObjectLocation = objectLocation;
    }

    public boolean isDeleted() {
        return IsDeleted;
    }

    public void setDeleted(boolean deleted) {
        IsDeleted = deleted;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getTargetNumber() {
        return TargetNumber;
    }

    public void setPargetNumber(String targetNumber) {
        TargetNumber = targetNumber;
    }


}
