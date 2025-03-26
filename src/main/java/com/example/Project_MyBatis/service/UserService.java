package com.example.Project_MyBatis.service;

import com.example.Project_MyBatis.mapper.UserMapper;
import com.example.Project_MyBatis.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserByUsername(String username) {
        return this.userMapper.findByUsername(username);
    }
}
