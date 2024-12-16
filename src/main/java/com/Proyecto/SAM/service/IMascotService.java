package com.Proyecto.SAM.service;

import com.Proyecto.SAM.entity.Mascot;

import java.util.List;
import java.util.Optional;

public interface IMascotService {

    Mascot save(Mascot mascot);
    void deleteById(Integer id);
    void update(Mascot mascot);
    Optional<Mascot> findById(Integer id);
    List<Mascot> findAll();
}
