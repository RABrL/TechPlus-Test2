package com.example.back.infrastructure.output.jpa.repository;

import com.example.back.infrastructure.output.jpa.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICommentRepository extends JpaRepository<CommentEntity, Long>{
    Optional<CommentEntity> findByUserId(Long userId);

    Optional<CommentEntity> findByQueryId(String queryId);
}
