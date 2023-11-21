package com.example.back.application.mapper.response;

import com.example.back.application.dto.response.QueryResponseDto;
import com.example.back.domain.model.Query;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = {IUserResponseMapper.class, ICommentResponseMapper.class})
public interface IQueryResponseMapper {

    IUserResponseMapper userMapper = Mappers.getMapper(IUserResponseMapper.class);
    ICommentResponseMapper commentMapper = Mappers.getMapper(ICommentResponseMapper.class);

    default QueryResponseDto toResponse(Query query) {
        QueryResponseDto queryResponse = new QueryResponseDto();
        queryResponse.setContent(query.getContent());
        queryResponse.setUser(userMapper.toResponse(query.getUser()));
        queryResponse.setComments(commentMapper.toResponseList(query.getComments()));
        queryResponse.setCreatedAt(query.getCreatedAt());
        return queryResponse;
    }

    default List<QueryResponseDto> toResponseList(List<Query> queryList) {
        if (queryList.isEmpty()) {
            return new ArrayList<>();
        }
        return queryList.stream()
                .map(query -> {
                    QueryResponseDto queryResponse = new QueryResponseDto();
                    queryResponse.setContent(query.getContent());
                    queryResponse.setUser(userMapper.toResponse(query.getUser()));
                    queryResponse.setComments(commentMapper.toResponseList(query.getComments()));
                    queryResponse.setCreatedAt(query.getCreatedAt());
                    return queryResponse;
                }).toList();
    }
}
