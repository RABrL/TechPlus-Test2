package com.example.back.infrastructure.output.jpa.mapper;

import com.example.back.domain.model.Comment;
import com.example.back.infrastructure.output.jpa.entity.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICommentEntityMapper {
    @Mapping(source = "queryId", target = "query.id")
    CommentEntity toEntity(Comment comment);

    @Mapping(source = "query.id", target = "queryId")
    Comment toComment(CommentEntity commentEntity);

    List<Comment> toCommentList(List<CommentEntity> commentEntities);
}
