package com.Proyecto.SAM.service;

import com.Proyecto.SAM.entity.Vaccine;

import java.util.List;
import java.util.Optional;

public interface IVaccineService {

    Vaccine save(Vaccine vaccine);
    void deleteById(Integer id);
    void update(Vaccine vaccine);
    Optional<Vaccine> findById(Integer id);
    List<Vaccine> findAll();
}
