package com.example.back.domain.spi;

import com.example.back.domain.model.Comment;

import java.util.List;
public interface ICommentPersistencePort {
    void saveComment(Comment comment);
    List<Comment> getAllComments();
    Comment getCommentById(Long id);
}
