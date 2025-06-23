package com.sgallalucas.workshop_mongo.controllers;

import com.sgallalucas.workshop_mongo.domain.User;
import com.sgallalucas.workshop_mongo.dtos.UserDTO;
import com.sgallalucas.workshop_mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> listDTO = userService.findAll();
        return ResponseEntity.ok().body(listDTO);
    }
}
