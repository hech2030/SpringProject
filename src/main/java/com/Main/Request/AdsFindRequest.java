package com.Main.Request;

public class AdsFindRequest {
    public int id;

    public int getCategId() {
        return categId;
    }

    public void setCategId(int categId) {
        this.categId = categId;
    }

    public int categId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AdsFindRequest(int id, int categId) {
        this.id = id;
        this.categId = categId;
    }

    public AdsFindRequest(){}
}
