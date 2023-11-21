package com.example.back.domain.api;

import com.example.back.domain.model.Comment;

import java.util.List;

public interface ICommentServicePort {
    void saveComment(Comment comment);
    List<Comment> getAllComments();
    Comment getCommentById(Long id);
}
