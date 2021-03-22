package com.Main.Models;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Table(name="ADD_AdDescription")
public class AdDescription {

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getKeyDesc() {
        return keyDesc;
    }

    public void setKeyDesc(String keyDesc) {
        this.keyDesc = keyDesc;
    }

    public String getValueDesc() {
        return valueDesc;
    }

    public void setValueDesc(String valueDesc) {
        this.valueDesc = valueDesc;
    }

    public Long getAdsId() {
        return AdsId;
    }

    public void setAdsId(Long adsId) {
        AdsId = adsId;
    }

    public AdDescription(long id, String keyDesc, String valueDesc, Long adsId) {
        Id = id;
        this.keyDesc = keyDesc;
        this.valueDesc = valueDesc;
        AdsId = adsId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String keyDesc;
    private String valueDesc;


    private Long AdsId;


    public AdDescription(){}
}
