package com.Proyecto.SAM.repository;

import com.Proyecto.SAM.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
