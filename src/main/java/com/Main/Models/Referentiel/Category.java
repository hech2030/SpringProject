package com.Main.Models.Referentiel;

import javax.persistence.*;

@Entity
@Table(name="ARC_AdReferentialCategories")
public class Category {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Label;

    public long getId() {
        return Id;
    }

    public Category(long id, String label) {
        Id = id;
        Label = label;
    }

    public Category(){}

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
