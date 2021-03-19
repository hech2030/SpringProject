package com.Main.Services;

import com.Main.Models.AdsEntityModel;
import com.Main.Repository.AdsEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AdsEntityServices {

    @Autowired
    private AdsEntityRepository _adsEntityRepository;

    public List<AdsEntityModel> find(long id) {
        if(id>0){
            var result = _adsEntityRepository.findById(id);
            if(result.isPresent())
                return Arrays.asList(result.get());
            else
                return  null;
        }
        return _adsEntityRepository.findByIsDeletedFalse();
    }
}
