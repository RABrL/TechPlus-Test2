package com.example.back.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class QueryResponseDto {
    private String content;
    private UserResponseDto user;

    private List<CommentResponseDto> comments;

    private Date createdAt;
}
