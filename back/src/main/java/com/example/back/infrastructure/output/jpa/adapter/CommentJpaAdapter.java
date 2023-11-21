package com.example.back.infrastructure.output.jpa.adapter;

import com.example.back.domain.exception.NoDataFoundException;
import com.example.back.domain.model.Comment;
import com.example.back.domain.spi.ICommentPersistencePort;
import com.example.back.infrastructure.output.jpa.mapper.ICommentEntityMapper;
import com.example.back.infrastructure.output.jpa.repository.ICommentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CommentJpaAdapter implements ICommentPersistencePort {
    private final ICommentRepository commentRepository;
    private final ICommentEntityMapper commentEntityMapper;

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(commentEntityMapper.toEntity(comment));
    }

    @Override
    public List<Comment> getAllComments() {
        return commentEntityMapper.toCommentList(commentRepository.findAll());
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentEntityMapper.toComment(commentRepository.findById(id).orElseThrow(NoDataFoundException::new));
    }
}
