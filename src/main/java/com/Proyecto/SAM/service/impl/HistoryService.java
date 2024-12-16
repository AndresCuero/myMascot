package com.Proyecto.SAM.service.impl;

import com.Proyecto.SAM.entity.History;
import com.Proyecto.SAM.repository.IHistoryRepository;
import com.Proyecto.SAM.service.IHistoryService;

import java.util.List;
import java.util.Optional;

public class HistoryService implements IHistoryService {

    IHistoryRepository iHistoryRepository;

    public HistoryService(IHistoryRepository iHistoryRepository) {
        this.iHistoryRepository = iHistoryRepository;
    }

    @Override
    public History save(History history) {
        return iHistoryRepository.save(history);
    }

    @Override
    public void update(History history) {
      iHistoryRepository.save(history);
    }

    @Override
    public void deleteById(Integer id) {
      Optional<History> historyReturn = iHistoryRepository.findById(id);
      if(historyReturn.isPresent()){
          iHistoryRepository.deleteById(id);
      }
    }

    @Override
    public Optional<History> findById(Integer id) {
        return iHistoryRepository.findById(id);
    }

    @Override
    public List<History> findAll() {
        return iHistoryRepository.findAll();
    }
}
