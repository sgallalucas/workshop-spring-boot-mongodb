package com.sgallalucas.workshop_mongo.services;

import com.sgallalucas.workshop_mongo.domain.User;
import com.sgallalucas.workshop_mongo.dtos.UserDTO;
import com.sgallalucas.workshop_mongo.repositories.UserRepository;
import com.sgallalucas.workshop_mongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        List<User> list = userRepository.findAll();
        return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    }

    public UserDTO findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return new UserDTO(user.orElseThrow(() -> new ObjectNotFoundException("Object not found.")));
    }

    public void insertUser(UserDTO dto) {
        User user = convertToEntity(dto);
        userRepository.insert(user);
    }

    public void deleteUser(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User convertToEntity(UserDTO dto){
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
}