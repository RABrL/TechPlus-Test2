package com.example.back.application.handler.impl;

import com.example.back.application.dto.request.CommentRequestDto;
import com.example.back.application.dto.response.CommentResponseDto;
import com.example.back.application.handler.ICommentHandler;
import com.example.back.application.mapper.request.ICommentRequestMapper;
import com.example.back.application.mapper.response.ICommentResponseMapper;
import com.example.back.domain.api.ICommentServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentHandler implements ICommentHandler {
    private final ICommentServicePort commentServicePort;
    private final ICommentResponseMapper commentResponseMapper;
    private final ICommentRequestMapper commentRequestMapper;


    @Override
    public void saveComment(CommentRequestDto commentRequestDto) {
        commentServicePort.saveComment(commentRequestMapper.toComment(commentRequestDto));
    }

    @Override
    public List<CommentResponseDto> getAllComments() {
        return commentResponseMapper.toResponseList(commentServicePort.getAllComments());
    }

    @Override
    public CommentResponseDto getCommentById(Long id) {
        return commentResponseMapper.toResponse(commentServicePort.getCommentById(id));
    }
}
