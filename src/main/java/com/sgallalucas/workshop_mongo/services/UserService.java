package com.sgallalucas.workshop_mongo.services;

import com.sgallalucas.workshop_mongo.domain.User;
import com.sgallalucas.workshop_mongo.dtos.UserDTO;
import com.sgallalucas.workshop_mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        List<User> list = userRepository.findAll();
        return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    }
}
