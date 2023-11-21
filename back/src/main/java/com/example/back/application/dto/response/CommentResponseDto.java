package com.example.back.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentResponseDto {
    private String content;
    private UserResponseDto user;
    private String queryId;
    private Date createdAt;

}
