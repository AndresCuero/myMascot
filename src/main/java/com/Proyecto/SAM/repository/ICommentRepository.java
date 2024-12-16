package com.Proyecto.SAM.repository;

import com.Proyecto.SAM.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment, Integer> {
}
