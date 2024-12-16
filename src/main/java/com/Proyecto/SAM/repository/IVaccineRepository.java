package com.Proyecto.SAM.repository;

import com.Proyecto.SAM.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVaccineRepository extends JpaRepository<Vaccine, Integer> {
}
