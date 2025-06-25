package com.sgallalucas.workshop_mongo.config;

import com.sgallalucas.workshop_mongo.domain.Post;
import com.sgallalucas.workshop_mongo.domain.User;
import com.sgallalucas.workshop_mongo.dtos.PostAuthorDTO;
import com.sgallalucas.workshop_mongo.repositories.PostRepository;
import com.sgallalucas.workshop_mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        Instant ins = Instant.now();

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Lucas", "lucas@gmail.com");
        User u2 = new User(null, "Gabriel", "gabriel@gmail.com");
        User u3 = new User(null, "Jorge", "jorge@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Post p1 = new Post(null, ins.atZone(ZoneId.systemDefault()).toInstant(), "Comentário", "Testando comentário", new PostAuthorDTO(u1));
        Post p2 = new Post(null, ins.atZone(ZoneId.systemDefault()).toInstant(), "Segundo comentário", "Testando segundo comentário", new PostAuthorDTO(u1));
        
        postRepository.saveAll(Arrays.asList(p1, p2));
    }
}
