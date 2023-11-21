package com.example.back.infrastructure.configuration;

import com.example.back.domain.api.ICommentServicePort;
import com.example.back.domain.api.IQueryServicePort;
import com.example.back.domain.api.IUserServicePort;
import com.example.back.domain.spi.ICommentPersistencePort;
import com.example.back.domain.spi.IQueryPersistencePort;
import com.example.back.domain.spi.IUserPersistencePort;
import com.example.back.domain.usecase.CommentUseCase;
import com.example.back.domain.usecase.QueryUseCase;
import com.example.back.domain.usecase.UserUseCase;
import com.example.back.infrastructure.output.jpa.adapter.CommentJpaAdapter;
import com.example.back.infrastructure.output.jpa.adapter.QueryJpaAdapter;
import com.example.back.infrastructure.output.jpa.adapter.UserJpaAdapter;
import com.example.back.infrastructure.output.jpa.mapper.ICommentEntityMapper;
import com.example.back.infrastructure.output.jpa.mapper.IQueryEntityMapper;
import com.example.back.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.example.back.infrastructure.output.jpa.repository.ICommentRepository;
import com.example.back.infrastructure.output.jpa.repository.IQueryRepository;
import com.example.back.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    public final IUserRepository userRepository;
    public final IUserEntityMapper userEntityMapper;
    public final ICommentRepository commentRepository;
    private final ICommentEntityMapper commentEntityMapper;
    private final IQueryRepository queryRepository;
    private final IQueryEntityMapper queryEntityMapper;
    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository,userEntityMapper);
    }
    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }
    @Bean
    public ICommentPersistencePort commentPersistencePort() {
        return new CommentJpaAdapter(commentRepository,commentEntityMapper);
    }
    @Bean
    public ICommentServicePort commentServicePort() {
        return new CommentUseCase(commentPersistencePort(), userPersistencePort(), queryPersistencePort());
    }
    @Bean
    public IQueryPersistencePort queryPersistencePort() {
        return new QueryJpaAdapter(queryRepository,queryEntityMapper);
    }
    @Bean
    public IQueryServicePort queryServicePort() {
        return new QueryUseCase(queryPersistencePort(),userPersistencePort());
    }
}
