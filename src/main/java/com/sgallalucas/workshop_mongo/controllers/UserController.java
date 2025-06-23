package com.sgallalucas.workshop_mongo.controllers;

import com.sgallalucas.workshop_mongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User u1 = new User("1", "Fulano", "fulano@gmail.com");
        User u2 = new User("2", "Ciclano", "ciclano@gmail.com");
        List<User> list = Arrays.asList(u1, u2);
        return ResponseEntity.ok().body(list);
    }
}
