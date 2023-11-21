package com.example.back.application.handler.impl;

import com.example.back.application.dto.request.QueryRequestDto;
import com.example.back.application.dto.response.QueryResponseDto;
import com.example.back.application.handler.IQueryHandler;
import com.example.back.application.mapper.request.IQueryRequestMapper;
import com.example.back.application.mapper.response.IQueryResponseMapper;
import com.example.back.domain.api.IQueryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryHandler implements IQueryHandler {
    private final IQueryServicePort queryServicePort;
    private final IQueryResponseMapper queryResponseMpper;
    private final IQueryRequestMapper queryRequestMapper;
    @Override
    public void saveQuery(QueryRequestDto query) {
        queryServicePort.saveQuery(queryRequestMapper.toQuery(query));
    }

    @Override
    public List<QueryResponseDto> getAllQueries() {
        return queryResponseMpper.toResponseList(queryServicePort.getAllQueries());
    }

    @Override
    public QueryResponseDto getQueryById(String id) {
        return queryResponseMpper.toResponse(queryServicePort.getQueryById(id));
    }
}
