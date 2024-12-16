package com.Proyecto.SAM.service.impl;

import com.Proyecto.SAM.entity.Rol;
import com.Proyecto.SAM.repository.IRolRepository;
import com.Proyecto.SAM.service.IRolService;

import java.util.List;
import java.util.Optional;

public class RolService implements IRolService {

    IRolRepository iRolRepository;

    public RolService(IRolRepository iRolRepository) {
        this.iRolRepository = iRolRepository;
    }

    @Override
    public Rol save(Rol rol) {
        return iRolRepository.save(rol);
    }

    @Override
    public void deleteById(Integer id) {
       Optional<Rol> rolReturn = iRolRepository.findById(id);
               if(rolReturn.isPresent()){
                   iRolRepository.deleteById(id);
               }
    }

    @Override
    public void update(Rol rol) {

    }

    @Override
    public Optional<Rol> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Rol> findAll() {
        return List.of();
    }
}
