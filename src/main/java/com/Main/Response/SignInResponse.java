package com.Main.Response;

import com.Main.Security.AppUser;
import com.Main.Security.JwtResponse;

public class SignInResponse {
    public SignInResponse(){}

    public SignInResponse(JwtResponse token, AppUser value) {
        this.token = token;
        this.value = value;
    }

    private JwtResponse token;
    private AppUser value;

    public JwtResponse getToken() {
        return token;
    }

    public void setToken(JwtResponse token) {
        this.token = token;
    }

    public AppUser getValue() {
        return value;
    }

    public void setValue(AppUser value) {
        this.value = value;
    }
}
