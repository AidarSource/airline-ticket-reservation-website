package org.example.airline.service;

import org.example.airline.entity.User;
import org.example.airline.repos.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername( String username ) {
        return userRepository.findByUsername( username );
    }

    @Override
    public void save( User user ) {
        userRepository.save( user );
    }

    @Override
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }
}
