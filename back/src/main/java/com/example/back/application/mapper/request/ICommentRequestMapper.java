package com.example.back.application.mapper.request;

import com.example.back.application.dto.request.CommentRequestDto;
import com.example.back.domain.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICommentRequestMapper {
    @Mapping(source = "userId", target = "user.id")
    Comment toComment(CommentRequestDto commentRequestDto);

}
