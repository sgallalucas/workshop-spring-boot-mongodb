package com.sgallalucas.workshop_mongo.controllers;

import com.sgallalucas.workshop_mongo.dtos.PostDTO;
import com.sgallalucas.workshop_mongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDTO>> findAll() {
        List<PostDTO> postDTO = postService.findAll();
        return ResponseEntity.ok().body(postDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        PostDTO postDTO = postService.findById(id);
        return ResponseEntity.ok().body(postDTO);
    }
}
