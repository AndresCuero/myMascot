package com.Proyecto.SAM.service;

import com.Proyecto.SAM.entity.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService {

    Rol save(Rol rol);
    void deleteById(Integer id);
    void update(Rol rol);
    Optional<Rol> findById(Integer id);
    List<Rol> findAll();
}
