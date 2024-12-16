package com.Proyecto.SAM.service.impl;

import com.Proyecto.SAM.entity.Notifications;
import com.Proyecto.SAM.repository.INotificationsRepository;
import com.Proyecto.SAM.service.INotificationsService;

import java.util.List;
import java.util.Optional;

public class NotificationsService implements INotificationsService {

    INotificationsRepository iNotificationsRepository;

    public NotificationsService(INotificationsRepository iNotificationsRepository) {
        this.iNotificationsRepository = iNotificationsRepository;
    }

    @Override
    public Notifications save(Notifications notifications) {
        return iNotificationsRepository.save(notifications);
    }

    @Override
    public void deleteById(Integer id) {
       Optional<Notifications> notificationsReturn = iNotificationsRepository.findById(id);
       if(notificationsReturn.isPresent()){
           iNotificationsRepository.deleteById(id);
       }
    }

    @Override
    public void update(Notifications notifications) {
       iNotificationsRepository.save(notifications);
    }

    @Override
    public Optional<Notifications> findById(Integer id) {
        return iNotificationsRepository.findById(id);
    }

    @Override
    public List<Notifications> findAll() {
        return iNotificationsRepository.findAll();
    }
}
