package com.Proyecto.SAM.service;

import com.Proyecto.SAM.entity.Race;

import java.util.List;
import java.util.Optional;

public interface IRaceService {

    Race save(Race race);
    void deleteById(Integer id);
    void update(Race race);
    Optional<Race> findById(Integer id);
    List<Race> findAll();
}
