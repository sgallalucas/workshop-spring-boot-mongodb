package com.sgallalucas.workshop_mongo.config;

import com.sgallalucas.workshop_mongo.domain.User;
import com.sgallalucas.workshop_mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User u1 = new User(null, "Lucas", "lucas@gmail.com");
        User u2 = new User(null, "Gabriel", "gabriel@gmail.com");
        User u3 = new User(null, "Jorge", "jorge@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
    }
}
