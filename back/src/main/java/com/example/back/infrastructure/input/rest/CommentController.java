package com.example.back.infrastructure.input.rest;

import com.example.back.application.dto.request.CommentRequestDto;
import com.example.back.application.dto.response.CommentResponseDto;
import com.example.back.application.handler.ICommentHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController {
    private final ICommentHandler commentHandler;

    @PostMapping("/")
    public ResponseEntity<Void> saveComment(@Valid @RequestBody CommentRequestDto commentRequestDto){
        commentHandler.saveComment(commentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, List<CommentResponseDto>>> getAllComments(){
        return ResponseEntity.ok(Collections.singletonMap("comments", commentHandler.getAllComments()));
    }


}
