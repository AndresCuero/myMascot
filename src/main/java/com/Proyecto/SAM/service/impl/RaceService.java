package com.Proyecto.SAM.service.impl;

import com.Proyecto.SAM.entity.Race;
import com.Proyecto.SAM.repository.IRaceRepository;
import com.Proyecto.SAM.service.IRaceService;

import java.util.List;
import java.util.Optional;

public class RaceService implements IRaceService {

    IRaceRepository iRaceRepository;

    public RaceService(IRaceRepository iRaceRepository) {
        this.iRaceRepository = iRaceRepository;
    }

    @Override
    public Race save(Race race) {
        return iRaceRepository.save(race);
    }

    @Override
    public void deleteById(Integer id) {
     Optional<Race> raceReturn = iRaceRepository.findById(id);
     if(raceReturn.isPresent()){
         iRaceRepository.deleteById(id);
     }
    }

    @Override
    public void update(Race race) {
      iRaceRepository.save(race);
    }

    @Override
    public Optional<Race> findById(Integer id) {
        return iRaceRepository.findById(id);
    }

    @Override
    public List<Race> findAll() {
        return iRaceRepository.findAll();
    }
}
