package com.Proyecto.SAM.service;

import com.Proyecto.SAM.entity.Species;

import java.util.List;
import java.util.Optional;

public interface ISpeciesService {

    Species save(Species species);
    void deleteById(Integer id);
    void update(Species species);
    Optional<Species> findById(Integer id);
    List<Species> findAll();
}
