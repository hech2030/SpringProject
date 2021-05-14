package com.Main.Request;

public class FindUserRequest {
    public FindUserRequest(long id){
        this.Id = id;
    }

    public Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public FindUserRequest(){}
}
