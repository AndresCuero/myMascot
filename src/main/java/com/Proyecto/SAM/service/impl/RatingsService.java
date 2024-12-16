package com.Proyecto.SAM.service.impl;

import com.Proyecto.SAM.entity.Ratings;
import com.Proyecto.SAM.repository.IRatingsRepository;
import com.Proyecto.SAM.service.IRatingsService;

import java.util.List;
import java.util.Optional;

public class RatingsService implements IRatingsService {

    IRatingsRepository iRatingsRepository;

    public RatingsService(IRatingsRepository iRatingsRepository) {
        this.iRatingsRepository = iRatingsRepository;
    }

    @Override
    public Ratings save(Ratings ratings) {
        return iRatingsRepository.save(ratings);
    }

    @Override
    public void deleteById(Integer id) {
         Optional<Ratings> ratingsReturn = iRatingsRepository.findById(id);
         if(ratingsReturn.isPresent()){
             iRatingsRepository.deleteById(id);
         }
    }

    @Override
    public void update(Ratings ratings) {
        iRatingsRepository.save(ratings);
    }

    @Override
    public Optional<Ratings> findById(Integer id) {
        return iRatingsRepository.findById(id);
    }

    @Override
    public List<Ratings> findAll() {
        return iRatingsRepository.findAll();
    }
}
