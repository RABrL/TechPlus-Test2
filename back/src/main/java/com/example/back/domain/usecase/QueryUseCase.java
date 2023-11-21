package com.example.back.domain.usecase;

import com.example.back.domain.api.IQueryServicePort;
import com.example.back.domain.exception.NoDataFoundException;
import com.example.back.domain.model.Query;
import com.example.back.domain.spi.IQueryPersistencePort;
import com.example.back.domain.spi.IUserPersistencePort;

import java.util.List;

public class QueryUseCase implements IQueryServicePort {
    private final IQueryPersistencePort queryPersistencePort;
    private final IUserPersistencePort userPersistencePort;

    public QueryUseCase(IQueryPersistencePort queryPersistencePort, IUserPersistencePort userPersistencePort) {
        this.queryPersistencePort = queryPersistencePort;
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveQuery(Query query) {
        userPersistencePort.getUserById(query.getUser().getId()); // Throw UserNotFoundException if user not exist
        queryPersistencePort.saveQuery(query);
    }

    @Override
    public List<Query> getAllQueries() {
        List<Query> queryList = queryPersistencePort.getAllQueries();
        if (queryList.isEmpty()) throw new NoDataFoundException("No queries found");
        return queryList;
    }

    @Override
    public Query getQueryById(String id) {
        return queryPersistencePort.getQueryById(id);
    }
}
