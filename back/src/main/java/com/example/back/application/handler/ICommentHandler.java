package com.example.back.application.handler;

import com.example.back.application.dto.request.CommentRequestDto;
import com.example.back.application.dto.response.CommentResponseDto;

import java.util.List;

public interface ICommentHandler {
    void saveComment(CommentRequestDto commentRequestDto);
    List<CommentResponseDto> getAllComments();
    CommentResponseDto getCommentById(Long id);
}
