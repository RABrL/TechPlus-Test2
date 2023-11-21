package com.example.back.infrastructure.output.jpa.adapter;

import com.example.back.domain.exception.QueryNotFoundException;
import com.example.back.domain.model.Query;
import com.example.back.domain.spi.IQueryPersistencePort;
import com.example.back.infrastructure.output.jpa.mapper.IQueryEntityMapper;
import com.example.back.infrastructure.output.jpa.repository.IQueryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class QueryJpaAdapter implements IQueryPersistencePort {
    private final IQueryRepository queryRepository;
    private final IQueryEntityMapper queryEntityMapper;
    @Override
    public void saveQuery(Query query) {
        queryRepository.save(queryEntityMapper.toEntity(query));
    }

    @Override
    public List<Query> getAllQueries() {
        return queryEntityMapper.toQueryList(queryRepository.findAll());
    }

    @Override
    public Query getQueryById(String id) {
        return queryEntityMapper.toQuery(queryRepository.findById(id).orElseThrow(QueryNotFoundException::new));
    }
}
