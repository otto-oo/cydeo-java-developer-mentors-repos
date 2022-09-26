package com.cydeo.service;

import com.cydeo.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public void save(User user);
}
