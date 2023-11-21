package com.example.back.application.mapper.response;

import com.example.back.application.dto.response.CommentResponseDto;
import com.example.back.domain.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = {IUserResponseMapper.class})
public interface ICommentResponseMapper {

    IUserResponseMapper userResponseMapper = Mappers.getMapper(IUserResponseMapper.class);

    default CommentResponseDto toResponse(Comment comment) {
        CommentResponseDto commentResponse = new CommentResponseDto();
        commentResponse.setContent(comment.getContent());
        commentResponse.setCreatedAt(comment.getCreatedAt());
        commentResponse.setUser(userResponseMapper.toResponse(comment.getUser()));
        commentResponse.setQueryId(comment.getQueryId());
        return commentResponse;
    }

    List<CommentResponseDto> toResponseList(List<Comment> commentList);
}
