package com.Proyecto.SAM.service;

import com.Proyecto.SAM.entity.History;

import java.util.List;
import java.util.Optional;

public interface IHistoryService {

    History save(History history);
    void update(History history);
    void deleteById(Integer id);
    Optional<History> findById(Integer id);
    List<History> findAll();
}
