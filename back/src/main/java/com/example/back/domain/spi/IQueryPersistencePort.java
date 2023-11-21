package com.example.back.domain.spi;

import com.example.back.domain.model.Query;

import java.util.List;
public interface IQueryPersistencePort {
    void saveQuery(Query query);
    List<Query> getAllQueries();
    Query getQueryById(String id);
}

