package com.example.back.application.handler;

import com.example.back.application.dto.request.UserRequestDto;
import com.example.back.application.dto.response.UserResponseDto;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IUserHandler {
    void saveUser(@NotNull UserRequestDto userRequestDto);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserByName(String name);
}
