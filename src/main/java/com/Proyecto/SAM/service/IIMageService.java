package com.Proyecto.SAM.service;

import com.Proyecto.SAM.entity.Image;

import java.util.List;
import java.util.Optional;

public interface IIMageService {

    Image save(Image image);
    void deleteById(Integer id);
    void update(Image image);
    Optional<Image> findById(Integer id);
    List<Image> findAll();
}
