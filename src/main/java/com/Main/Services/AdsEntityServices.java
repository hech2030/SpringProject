package com.Main.Services;

import com.Main.Models.AdsEntityModel;
import com.Main.Models.Referentiel.Category;
import com.Main.Models.Referentiel.SubCategory;
import com.Main.Repository.AdsEntityRepository;
import com.Main.Repository.CategoryEntityRepository;
import com.Main.Repository.SubCategoryEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class AdsEntityServices {

    @Autowired
    private AdsEntityRepository _adsEntityRepository;
    @Autowired
    private CategoryEntityRepository _CategoryEntityRepository;
    @Autowired
    private SubCategoryEntityRepository _subCategoryEntityRepository;

    public List<AdsEntityModel> find(long id, long categId, long userId) {
        if(id>0){
            var result = _adsEntityRepository.findById(id);
            if(result.isPresent())
                return Arrays.asList(result.get());
            else
                return  null;
        }
        if(categId>0){
            var cat = _CategoryEntityRepository.findById(categId);
            if(cat.isPresent()) {
                var result = _adsEntityRepository.findBycategoryAndIsDeletedFalse(cat.get());
                if (!result.isEmpty())
                    return result;
                else
                    return null;
            }
        }
        if(userId > 0){
            var result = _adsEntityRepository.findByUserId(userId);
            if(!result.isEmpty())
                return result;
            else
                return  null;
        }
        return _adsEntityRepository.findByIsDeletedFalse();
    }

    public AdsEntityModel save(AdsEntityModel value){
        try{
            value.setCreationDate(new Date());
            return _adsEntityRepository.save(value);
        }
        catch (Exception ex){
         System.out.println(ex.getMessage());
         return null;
        }
    }

    public boolean delete(long id){
        var value = _adsEntityRepository.findById(id);
        if(value.isPresent() && value.get() != null){
            var valueToSave = value.get();
            valueToSave.setDeleted(true);
            _adsEntityRepository.saveAndFlush(valueToSave);
            return true;
        }
        return false;
    }
    public List<Category> FindCategory(){
        return _CategoryEntityRepository.findAll();
    }

    public List<SubCategory> FindSubCategory(long categoryId){
        return _subCategoryEntityRepository.findByCategoryId(categoryId);
    }
}
