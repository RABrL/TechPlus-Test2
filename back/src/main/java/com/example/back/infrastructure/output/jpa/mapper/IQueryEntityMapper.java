package com.example.back.infrastructure.output.jpa.mapper;

import com.example.back.domain.model.Query;
import com.example.back.infrastructure.output.jpa.entity.QueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {ICommentEntityMapper.class})
public interface IQueryEntityMapper {
    QueryEntity toEntity(Query query);
    Query toQuery(QueryEntity queryEntity);
    List<Query> toQueryList(List<QueryEntity> queryEntities);

}
