package com.example.back.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDto {
    @NotBlank(message = "Content is required")
    private String content;
    @NotNull(message = "User id is not provided")
    private Long userId;
    @NotBlank(message = "Query id is not provided")
    private String queryId;
}
