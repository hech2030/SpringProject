package com.Main.Repository;

import com.Main.Models.AdsEntityModel;
import com.Main.Models.Referentiel.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdsEntityRepository extends JpaRepository<AdsEntityModel, Long> {
    List<AdsEntityModel> findByIsDeletedFalse();
    List<AdsEntityModel> findBycategory(Category category);
    @Query(value = "select * from AEM_AdEntityModel ads inner join OEM_OwnerEntityModel usr on ads.ownerId = usr.id where usr.id = ?", nativeQuery = true)
    List<AdsEntityModel> findByUserId(long userId);
}