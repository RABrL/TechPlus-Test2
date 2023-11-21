package com.example.back.domain.usecase;

import com.example.back.domain.api.IUserServicePort;
import com.example.back.domain.exception.NoDataFoundException;
import com.example.back.domain.exception.UserAlreadyExistException;
import com.example.back.domain.model.User;
import com.example.back.domain.spi.IUserPersistencePort;

import java.util.List;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(User user) {
        try {
            // Check if user already exist
            userPersistencePort.getUserByName(user.getName());
        } catch (Exception e) {
            userPersistencePort.saveUser(user);
        }
        throw new UserAlreadyExistException();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userPersistencePort.getAllUsers();
        if(userList.isEmpty()) throw new NoDataFoundException("No users found");
        return userList;
    }

    @Override
    public User getUserByName(String name) {
        return userPersistencePort.getUserByName(name);
    }

    @Override
    public User getUserById(Long id) {
        return userPersistencePort.getUserById(id);
    }
}
