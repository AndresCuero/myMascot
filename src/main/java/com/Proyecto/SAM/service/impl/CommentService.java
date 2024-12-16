package com.Proyecto.SAM.service.impl;

import com.Proyecto.SAM.entity.Comment;
import com.Proyecto.SAM.repository.ICommentRepository;
import com.Proyecto.SAM.service.ICommentService;


import java.util.List;
import java.util.Optional;

public class CommentService implements ICommentService {

    ICommentRepository iCommentRepository;

    public CommentService(ICommentRepository iCommentRepository) {
        this.iCommentRepository = iCommentRepository;
    }

    @Override
    public Comment save(Comment comment) {
      return  iCommentRepository.save(comment);
    }

    @Override
    public void deleteById(Integer id)  {
      Optional<Comment> commentReturn = iCommentRepository.findById(id);
      if(commentReturn.isPresent()){
          iCommentRepository.deleteById(id);
      }

    }

    @Override
    public void update(Comment comment) {
        iCommentRepository.save(comment);
    }

    @Override
    public Optional<Comment> findById(Integer id) {
        return iCommentRepository.findById(id);
    }

    @Override
    public List<Comment> findAll() {
        return iCommentRepository.findAll();
    }
}
