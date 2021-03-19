package com.Main;

import com.Main.Models.AdsEntityModel;
import com.Main.Request.AdsFindRequest;
import com.Main.Request.AdsSaveRequest;
import com.Main.Security.JwtResponse;
import com.Main.Security.SignInRequest;
import com.Main.Services.AdsEntityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/api/v1/MainApp")
public class HomeController {

    @Autowired
    private AdsEntityServices _adsEntityServices;

    @PostMapping(value = {"/home"})
    public List<AdsEntityModel> getAllAds(@RequestBody AdsFindRequest findRequest) {
        int id = findRequest != null ? findRequest.id : 0;
        return _adsEntityServices.find(id);
    }

    @PostMapping(value = {"/SaveAd"})
    public AdsEntityModel SaveAd(@RequestBody AdsSaveRequest saveRequest) {
        if(saveRequest.value != null)
            return _adsEntityServices.save(saveRequest.value);
        return null;
    }
}
