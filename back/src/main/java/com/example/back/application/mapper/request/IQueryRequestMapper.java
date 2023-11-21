package com.example.back.application.mapper.request;

import com.example.back.application.dto.request.QueryRequestDto;
import com.example.back.domain.model.Query;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IQueryRequestMapper {
    @Mapping(source = "userId", target = "user.id")
    Query toQuery(QueryRequestDto queryRequestDto);
}
