package org.example.airline.service;

import org.example.airline.entity.User;

public interface UserService {
    User findByUsername(String username);
    void save(User user);
    Iterable<User> findAllUsers();
}
