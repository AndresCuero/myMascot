package com.Proyecto.SAM.service.impl;

import com.Proyecto.SAM.entity.Vaccine;
import com.Proyecto.SAM.repository.IVaccineRepository;
import com.Proyecto.SAM.service.IVaccineService;

import java.util.List;
import java.util.Optional;

public class VaccineService implements IVaccineService {

    IVaccineRepository iVaccineRepository;

    public VaccineService(IVaccineRepository iVaccineRepository) {
        this.iVaccineRepository = iVaccineRepository;
    }

    @Override
    public Vaccine save(Vaccine vaccine) {
        return iVaccineRepository.save(vaccine);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Vaccine> vaccineReturn = iVaccineRepository.findById(id);
        if(vaccineReturn.isPresent()){
            iVaccineRepository.deleteById(id);
        }

    }

    @Override
    public void update(Vaccine vaccine) {
       iVaccineRepository.save(vaccine);
    }

    @Override
    public Optional<Vaccine> findById(Integer id) {
        return iVaccineRepository.findById(id);
    }

    @Override
    public List<Vaccine> findAll() {
        return iVaccineRepository.findAll();
    }
}
