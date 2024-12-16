package com.Proyecto.SAM.service;

import com.Proyecto.SAM.entity.Notifications;

import java.util.List;
import java.util.Optional;

public interface INotificationsService {

    Notifications save(Notifications notifications);
    void deleteById(Integer id);
    void update(Notifications notifications);
    Optional<Notifications> findById(Integer id);
    List<Notifications> findAll();
}
