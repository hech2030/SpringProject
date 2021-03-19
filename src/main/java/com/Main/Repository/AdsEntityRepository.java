package com.Main.Repository;

import com.Main.Models.AdsEntityModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdsEntityRepository extends JpaRepository<AdsEntityModel, Long> {
    public List<AdsEntityModel> findByIsDeletedFalse();
}
