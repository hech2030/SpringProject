package com.Main;

import com.Main.Models.AdsEntityModel;
import com.Main.Request.AdsFindRequest;
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

    //@RequestMapping("/")
    //public String test(){
     //   return "hello, welcome";
    //}

    //@RequestMapping(value = {"/home", "/home/{id}"})
    //public List<AdsEntityModel> listAds(@PathVariable(required = false) Integer id){
     //   id = id != null ? id : 0;
      //  return _adsEntityServices.find(id);
    //}

    @PostMapping(value = {"/homee"})
    public List<AdsEntityModel> getAllAds(@RequestBody AdsFindRequest findRequest) {
        int id = findRequest != null ? findRequest.id : 0;
        return _adsEntityServices.find(id);
    }
}
