package com.Proyecto.SAM.service.impl;

import com.Proyecto.SAM.entity.Species;
import com.Proyecto.SAM.repository.ISpeciesRepository;
import com.Proyecto.SAM.service.ISpeciesService;

import java.util.List;
import java.util.Optional;

public class SpeciesService implements ISpeciesService {

    ISpeciesRepository iSpeciesRepository;

    public SpeciesService(ISpeciesRepository iSpeciesRepository) {
        this.iSpeciesRepository = iSpeciesRepository;
    }

    @Override
    public Species save(Species species) {
        return iSpeciesRepository.save(species);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Species> speciesReturn = iSpeciesRepository.findById(id);
                if(speciesReturn.isPresent()){
                    iSpeciesRepository.deleteById(id);
                }
    }

    @Override
    public void update(Species species) {
        iSpeciesRepository.save(species);
    }

    @Override
    public Optional<Species> findById(Integer id) {
        return iSpeciesRepository.findById(id);
    }

    @Override
    public List<com.Proyecto.SAM.entity.Species> findAll() {
        return iSpeciesRepository.findAll();
    }
}
