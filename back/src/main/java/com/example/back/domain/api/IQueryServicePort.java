package com.example.back.domain.api;

import com.example.back.domain.model.Query;

import java.util.List;

public interface IQueryServicePort {
    void saveQuery(Query query);
    List<Query> getAllQueries();
    Query getQueryById(String id);
}
