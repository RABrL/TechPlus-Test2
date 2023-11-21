package com.example.back.application.handler.impl;

import com.example.back.application.dto.request.UserRequestDto;
import com.example.back.application.dto.response.UserResponseDto;
import com.example.back.application.handler.IUserHandler;
import com.example.back.application.mapper.request.*;
import com.example.back.application.mapper.response.IUserResponseMapper;
import com.example.back.domain.api.IUserServicePort;
import com.example.back.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserHandler implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;

    @Override
    public void saveUser(@NotNull UserRequestDto userRequestDto) {
        User user = userRequestMapper.toUser(userRequestDto);
        userServicePort.saveUser(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userResponseMapper.toResponseList(userServicePort.getAllUsers());
    }

    @Override
    public UserResponseDto getUserByName(String name) {
        return userResponseMapper.toResponse(userServicePort.getUserByName(name));
    }
}
