package com.example.demo.controller;

import com.example.demo.entity.User;
import java.util.List;

import com.example.demo.service.IUserService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserMapper;


@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private IUserService userService;

    @RequestMapping(value={"/selectUserById"}, method=RequestMethod.GET)
    public User selectUserById(String id){
        User user = userMapper.selectUserById(Integer.parseInt(id));
        return user;
    }

    @RequestMapping(value={"/selectUserByName"}, method=RequestMethod.GET)
    public List<User> selectUserByName(String userName){
        return userMapper.selectUserByName(userName);
    }

    @RequestMapping(value={"/addUser"}, method={RequestMethod.GET,RequestMethod.POST})
    public User addUser(User user){
        userMapper.addUser(user);
        return user;
    }

    @RequestMapping(value={"/updateUser"}, method={RequestMethod.GET,RequestMethod.POST})
    public User updateUser(User user){
        userService.updateUser(user);
        return user;
    }

    @RequestMapping(value={"/deleteUser"}, method={RequestMethod.GET,RequestMethod.POST})
    public void deleteUser(String id){
        userMapper.deleteUser(Integer.parseInt(id));
    }
}