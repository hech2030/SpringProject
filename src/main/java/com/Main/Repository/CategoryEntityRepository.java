package com.Main.Repository;

import com.Main.Models.Referentiel.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryEntityRepository extends JpaRepository<Category, Long> {
}
