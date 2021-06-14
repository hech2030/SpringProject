package com.Main.Repository;

import com.Main.Models.Referentiel.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryEntityRepository extends JpaRepository<SubCategory, Long> {
    List<SubCategory> findByCategoryId(long categoryId);
}
