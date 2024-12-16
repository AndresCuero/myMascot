package com.Proyecto.SAM.service.impl;

import com.Proyecto.SAM.entity.User;
import com.Proyecto.SAM.repository.IUserRepository;
import com.Proyecto.SAM.service.IUserService;

import java.util.List;
import java.util.Optional;

public class UserService implements IUserService {

    IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public User save(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<User> userReturn = iUserRepository.findById(id);
        if(userReturn.isPresent()){
            iUserRepository.deleteById(id);
        }

    }

    @Override
    public void update(User user) {
      iUserRepository.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return iUserRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }
}
