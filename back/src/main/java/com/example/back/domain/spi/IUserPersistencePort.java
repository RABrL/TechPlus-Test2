package com.example.back.domain.spi;

import com.example.back.domain.model.User;

import java.util.List;

public interface IUserPersistencePort {
    void saveUser(User user);
    List<User> getAllUsers();
    User getUserByName(String name);
    User getUserById(Long id);
}
