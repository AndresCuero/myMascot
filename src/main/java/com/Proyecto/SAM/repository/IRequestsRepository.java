package com.Proyecto.SAM.repository;

import com.Proyecto.SAM.entity.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRequestsRepository extends JpaRepository<Requests, Integer> {
}
