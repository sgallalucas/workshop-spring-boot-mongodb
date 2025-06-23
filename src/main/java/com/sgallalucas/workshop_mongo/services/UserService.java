package com.sgallalucas.workshop_mongo.services;

import com.sgallalucas.workshop_mongo.domain.User;
import com.sgallalucas.workshop_mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
