package com.example.back.application.handler;

import com.example.back.application.dto.request.QueryRequestDto;
import com.example.back.application.dto.response.QueryResponseDto;

import java.util.List;

public interface IQueryHandler {
    void saveQuery(QueryRequestDto query);
    List<QueryResponseDto> getAllQueries();
    QueryResponseDto getQueryById(String id);
}
