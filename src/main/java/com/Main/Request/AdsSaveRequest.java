package com.Main.Request;

import com.Main.Models.AdsEntityModel;

public class AdsSaveRequest {
    public AdsSaveRequest(AdsEntityModel value) {
        this.value = value;
    }

    public AdsEntityModel getValue() {
        return value;
    }

    public void setValue(AdsEntityModel value) {
        this.value = value;
    }

    public AdsEntityModel value;
    public AdsSaveRequest(){}
}
