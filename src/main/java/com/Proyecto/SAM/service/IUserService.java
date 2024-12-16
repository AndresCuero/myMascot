package com.Proyecto.SAM.service;

import com.Proyecto.SAM.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    User save(User user);
    void deleteById(Integer id);
    void update(User user);
    Optional<User> findById(Integer id);
    List<User> findAll();
}
