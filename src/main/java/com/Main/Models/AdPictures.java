package com.Main.Models;

import javax.persistence.*;

@Entity
@Table(name="ADP_AdPictures")
public class AdPictures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String content;
    private Long AdsPId;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAdsId() {
        return AdsPId;
    }

    public void setAdsId(Long adsId) {
        AdsPId = adsId;
    }

    public AdPictures(long id, String content, Long adsId) {
        Id = id;
        this.content = content;
        AdsPId = adsId;
    }
    public AdPictures(){}


}
