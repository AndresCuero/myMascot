package com.Proyecto.SAM.service;

import com.Proyecto.SAM.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface ICommentService {

    Comment save(Comment comment);
    void deleteById(Integer id);
    void update(Comment comment);
    Optional<Comment> findById(Integer id);
    List<Comment> findAll();

}
