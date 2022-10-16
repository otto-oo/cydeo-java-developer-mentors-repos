package com.cydeo.user_creation.service.implementation;


import com.cydeo.user_creation.bootstrap.DataGenerator;
import com.cydeo.user_creation.model.User;
import com.cydeo.user_creation.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {
    @Override
    public List<User> getUsers() {
        return DataGenerator.USER_LIST;
    }

    @Override
    public void save(User user) {
        DataGenerator.USER_LIST.add(user);
    }

    @Override
    public User findByEmail(String email) {
        return getUsers().stream().filter(user -> user.getEmail().equals(email)).findFirst().orElseThrow();
    }

    @Override
    public void update(User user) {
        User userInDB = findByEmail(user.getEmail());
        getUsers().remove(userInDB);
        save(user);
    }

    @Override
    public void delete(User user) {
        User forDeletion = getUsers().stream().filter(u -> u.getEmail().equals(user.getEmail())).findFirst().orElseThrow();
        getUsers().remove(forDeletion);
    }

    @Override
    public List<User> findAllUsersWithFirstName(String firstName) {
        return getUsers().stream().filter(user -> user.getFirstName().contains(firstName)).collect(Collectors.toList());
    }
}
