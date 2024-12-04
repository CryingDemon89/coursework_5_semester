package com.example.train_station.service;

import com.example.train_station.dto.UserDto ;
import com.example.train_station.entity.User;
import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}