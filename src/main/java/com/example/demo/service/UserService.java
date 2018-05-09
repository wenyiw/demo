package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}