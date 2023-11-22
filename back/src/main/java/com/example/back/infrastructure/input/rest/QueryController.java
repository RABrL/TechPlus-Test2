package com.example.back.infrastructure.input.rest;

import com.example.back.application.dto.request.QueryRequestDto;
import com.example.back.application.dto.response.QueryResponseDto;
import com.example.back.application.handler.IQueryHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
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
@RequestMapping("/api/v1/query")
public class QueryController {
    public final IQueryHandler queryHandler;

    @PostMapping("/")
    public ResponseEntity<Void> saveQuery(@Valid @RequestBody QueryRequestDto queryRequestDto) {
        queryHandler.saveQuery(queryRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, List<QueryResponseDto>>> getAllQueries(){
        return ResponseEntity.ok(Collections.singletonMap("queries", queryHandler.getAllQueries()));
    }
}
