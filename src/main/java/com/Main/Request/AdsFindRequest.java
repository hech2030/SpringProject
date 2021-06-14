package com.Main.Request;

public class AdsFindRequest {
    public int id;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int
                                  userId) {
        this.userId = userId;
    }

    public int userId;
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

    public AdsFindRequest(int id, int categId, int userId) {
        this.id = id;
        this.categId = categId;
        this.userId = userId;
    }

    public AdsFindRequest(){}
}
