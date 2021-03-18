package com.Main.Repository;

import com.Main.Models.AdsEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdsEntityRepository extends JpaRepository<AdsEntityModel, Long> {
}
