package com.Proyecto.SAM.repository;

import com.Proyecto.SAM.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRatingsRepository extends JpaRepository<Ratings, Integer> {
}
