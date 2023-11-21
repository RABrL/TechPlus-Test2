package com.example.back.infrastructure.output.jpa.repository;

import com.example.back.infrastructure.output.jpa.entity.QueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQueryRepository extends JpaRepository<QueryEntity, String> {

}
