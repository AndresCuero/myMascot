package com.Proyecto.SAM.repository;

import com.Proyecto.SAM.entity.Mascot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMascotRepository extends JpaRepository<Mascot, Integer> {
}
