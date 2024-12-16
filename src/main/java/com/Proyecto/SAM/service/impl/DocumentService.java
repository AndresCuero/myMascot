package com.Proyecto.SAM.service.impl;

import com.Proyecto.SAM.entity.Document;
import com.Proyecto.SAM.repository.IDocumentRepository;
import com.Proyecto.SAM.service.IDocumentService;

import java.util.List;
import java.util.Optional;

public class DocumentService implements IDocumentService {

    IDocumentRepository iDocumentRepository;

    public DocumentService(IDocumentRepository iDocumentRepository) {
        this.iDocumentRepository = iDocumentRepository;
    }

    @Override
    public Document save(Document document) {
        return iDocumentRepository.save(document);
    }

    @Override
    public void update(Document document) {
       iDocumentRepository.save(document);
    }

    @Override
    public void deleteById(Integer id) {
       Optional<Document> documentReturn = iDocumentRepository.findById(id);
       if(documentReturn.isPresent()){
           iDocumentRepository.deleteById(id);
       }
    }

    @Override
    public Optional<Document> findById(Integer id) {
        return iDocumentRepository.findById(id);
    }

    @Override
    public List<Document> findAll() {
        return iDocumentRepository.findAll();
    }
}
