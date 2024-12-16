package com.Proyecto.SAM.service;

import com.Proyecto.SAM.entity.Ratings;

import java.util.List;
import java.util.Optional;

public interface IRatingsService {

    Ratings save(Ratings ratings);
    void deleteById(Integer id);
    void update(Ratings ratings);
    Optional<Ratings> findById(Integer id);
    List<Ratings> findAll();
}
