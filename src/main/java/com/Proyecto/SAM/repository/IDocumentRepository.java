package com.Proyecto.SAM.repository;

import com.Proyecto.SAM.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentRepository extends JpaRepository<Document, Integer> {
}
