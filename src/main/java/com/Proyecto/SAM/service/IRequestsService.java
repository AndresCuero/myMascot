package com.Proyecto.SAM.service;

import com.Proyecto.SAM.entity.Requests;

import java.util.List;
import java.util.Optional;

public interface IRequestsService {

    Requests save(Requests requests);
    void deleteById(Integer id);
    void update(Requests requests);
    Optional<Requests> findById(Integer id);
    List<Requests> findAll();
}
