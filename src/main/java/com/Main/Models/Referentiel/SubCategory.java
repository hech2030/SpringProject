package com.Main.Models.Referentiel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "ARC_AdReferentialSubCategories")
public class SubCategory {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Label;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        categoryId = categoryId;
    }

    private long categoryId;

    public long getId() {
        return Id;
    }

    public SubCategory(long id, String label,long categoryId) {
        Id = id;
        Label = label;
        this.categoryId = categoryId;
    }

    public SubCategory(){}

    public void setId(long id) {
        Id = id;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }
}
