package com.Proyecto.SAM.repository;

import com.Proyecto.SAM.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpeciesRepository extends JpaRepository<Species, Integer> {
}
