package com.Main;

import com.Main.Models.AdsEntityModel;
import com.Main.Services.AdsEntityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/MainApp")
public class HomeController {

    @Autowired
    private AdsEntityServices _adsEntityServices;

    @RequestMapping("/")
    public String test(){
        return "hello, welcome";
    }

    @RequestMapping(value = {"/home", "/home/{id}"})
    public List<AdsEntityModel> listAds(@PathVariable(required = false) Integer id){
        id = id != null ? id : 0;
        return _adsEntityServices.find(id);
    }
}
