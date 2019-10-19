package com.example.demo.service.UserService.impl;

import com.example.demo.domain.User.User;
import com.example.demo.repository.UserRepository.UserRepository;
import com.example.demo.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static UserService userService = null;
    @Autowired
    private UserRepository userRepository;

    private UserServiceImpl(){}

    public static UserService getUserService() {
        if (userService == null)userService = new UserServiceImpl();
        return userService;
    }

    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User read(Integer s) {
        return this.userRepository.getOne(s);
    }

    @Override
    public User update(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void delete(Integer s) {
        this.userRepository.deleteById(s);
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }
}
