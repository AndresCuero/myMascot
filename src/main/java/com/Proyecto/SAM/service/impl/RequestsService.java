package com.Proyecto.SAM.service.impl;

import com.Proyecto.SAM.entity.Ratings;
import com.Proyecto.SAM.entity.Requests;
import com.Proyecto.SAM.repository.IRequestsRepository;
import com.Proyecto.SAM.service.IRatingsService;
import com.Proyecto.SAM.service.IRequestsService;

import java.util.List;
import java.util.Optional;

public class RequestsService implements IRequestsService {

    IRequestsRepository iRequestsRepository;

    public RequestsService(IRequestsRepository iRequestsRepository) {
        this.iRequestsRepository = iRequestsRepository;
    }

    @Override
    public Requests save(Requests requests) {
        return iRequestsRepository.save(requests);
    }

    @Override
    public void deleteById(Integer id) {
     Optional<Requests> requestsReturn = iRequestsRepository.findById(id);
     if(requestsReturn.isPresent()){
         iRequestsRepository.deleteById(id);
     }
    }

    @Override
    public void update(Requests requests) {
       iRequestsRepository.save(requests);
    }

    @Override
    public Optional<Requests> findById(Integer id) {
        return iRequestsRepository.findById(id);
    }

    @Override
    public List<Requests> findAll() {
        return iRequestsRepository.findAll();
    }
}
