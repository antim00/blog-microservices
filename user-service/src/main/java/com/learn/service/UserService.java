package com.learn.service;


import com.learn.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUser(Long id);
    List<User> getAllUsers();
}
