package com.Proyecto.SAM.service.impl;

import com.Proyecto.SAM.entity.Mascot;
import com.Proyecto.SAM.repository.IMascotRepository;
import com.Proyecto.SAM.service.IMascotService;

import java.util.List;
import java.util.Optional;

public class MascotService implements IMascotService {

    IMascotRepository iMascotRepository;

    public MascotService(IMascotRepository iMascotRepository) {
        this.iMascotRepository = iMascotRepository;
    }

    @Override
    public Mascot save(Mascot mascot) {
        return iMascotRepository.save(mascot);
    }

    @Override
    public void deleteById(Integer id) {
       Optional<Mascot> mascotReturn = iMascotRepository.findById(id);
       if(mascotReturn.isPresent()){
           iMascotRepository.deleteById(id);
       }
    }

    @Override
    public void update(Mascot mascot) {
       iMascotRepository.save(mascot);
    }

    @Override
    public Optional<Mascot> findById(Integer id) {
        return iMascotRepository.findById(id);
    }

    @Override
    public List<Mascot> findAll() {
        return iMascotRepository.findAll();
    }
}
