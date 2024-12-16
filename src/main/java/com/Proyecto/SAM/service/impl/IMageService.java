package com.Proyecto.SAM.service.impl;

import com.Proyecto.SAM.entity.Image;
import com.Proyecto.SAM.repository.IIMageRepository;
import com.Proyecto.SAM.service.IIMageService;

import java.util.List;
import java.util.Optional;

public class IMageService implements IIMageService {

    IIMageRepository iiMageRepository;

    public IMageService(IIMageRepository iiMageRepository) {
        this.iiMageRepository = iiMageRepository;
    }

    @Override
    public Image save(Image image) {
        return iiMageRepository.save(image) ;
    }

    @Override
    public void deleteById(Integer id) {
       Optional<Image> imageReturn = iiMageRepository.findById(id);
       if(imageReturn.isPresent()){
           iiMageRepository.deleteById(id);
       }
    }

    @Override
    public void update(Image image) {
        iiMageRepository.save(image);
    }

    @Override
    public Optional<Image> findById(Integer id) {
        return iiMageRepository.findById(id);
    }

    @Override
    public List<Image> findAll() {
        return iiMageRepository.findAll();
    }
}
