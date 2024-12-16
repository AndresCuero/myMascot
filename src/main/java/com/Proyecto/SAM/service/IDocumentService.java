package com.Proyecto.SAM.service;

import com.Proyecto.SAM.entity.Document;
import java.util.List;
import java.util.Optional;


public interface IDocumentService {

    Document save(Document document);
    void update(Document document);
    void deleteById(Integer id);
    Optional<Document> findById(Integer id);
    List<Document> findAll();
}
