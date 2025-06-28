package com.sgallalucas.workshop_mongo.config;

import com.sgallalucas.workshop_mongo.domain.Post;
import com.sgallalucas.workshop_mongo.domain.User;
import com.sgallalucas.workshop_mongo.dtos.AuthorDTO;
import com.sgallalucas.workshop_mongo.dtos.CommentDTO;
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

        Post p1 = new Post(null, ins.atZone(ZoneId.systemDefault()).toInstant(), "Rocket League", "O Major está muito bom!", new AuthorDTO(u1));
        Post p2 = new Post(null, ins.atZone(ZoneId.systemDefault()).toInstant(), "Futebol", "Ansioso para os jogos da Copa do Mundo", new AuthorDTO(u1));

        CommentDTO c1 = new CommentDTO("Testando comentário", ins.atZone(ZoneId.systemDefault()).toInstant(), new AuthorDTO(u2));
        CommentDTO c2 = new CommentDTO("Testando segundo comentário", ins.atZone(ZoneId.systemDefault()).toInstant(), new AuthorDTO(u2));
        CommentDTO c3 = new CommentDTO("Testando terceiro comentário", ins.atZone(ZoneId.systemDefault()).toInstant(), new AuthorDTO(u3));

        p1.getComments().addAll(Arrays.asList(c1, c2));
        p2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(p1, p2));

        u1.getPosts().addAll(Arrays.asList(p1, p2));
        userRepository.save(u1);
    }
}
