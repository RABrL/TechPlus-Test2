package com.example.back.infrastructure.output.jpa.adapter;

import com.example.back.domain.exception.UserNotFoundException;
import com.example.back.domain.model.User;
import com.example.back.domain.spi.IUserPersistencePort;
import com.example.back.infrastructure.output.jpa.entity.UserEntity;
import com.example.back.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.example.back.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    @Override
    public void saveUser(User user) {
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public List<User> getAllUsers() {
        return userEntityMapper.toUserList(userRepository.findAll());
    }

    @Override
    public User getUserByName(String name) {
        return userEntityMapper.toUser(userRepository.findByName(name).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public User getUserById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(userEntity.isEmpty()) throw new UserNotFoundException("User with id " + id + " not found");
        return userEntityMapper.toUser(userEntity.get());
    }
}
