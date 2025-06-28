package com.sgallalucas.workshop_mongo.services;

import com.sgallalucas.workshop_mongo.domain.Post;
import com.sgallalucas.workshop_mongo.dtos.PostDTO;
import com.sgallalucas.workshop_mongo.repositories.PostRepository;
import com.sgallalucas.workshop_mongo.services.exception.ObjectNotFoundException;
import com.sgallalucas.workshop_mongo.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostDTO> findAll() {
        List<Post> postList = postRepository.findAll();
        return postList.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
    }

    public PostDTO findById(String id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        return new PostDTO(post);
    }

    public List<PostDTO> searchTitle(String text) {
       List<Post> post = postRepository.searchTitle(text);
       return post.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
    }

    public List<PostDTO> fullSearch(String text, String minDate, String maxDate) {
        Instant convMinDate = URL.convertDate(minDate);
        Instant convMaxDate = URL.convertDate(maxDate);
        List<Post> postList = postRepository.fullSearch(text, convMinDate, convMaxDate);
        return postList.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
    }
}
