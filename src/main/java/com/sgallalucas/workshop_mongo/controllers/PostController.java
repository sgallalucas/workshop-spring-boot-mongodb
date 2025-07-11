package com.sgallalucas.workshop_mongo.controllers;

import com.sgallalucas.workshop_mongo.dtos.PostDTO;
import com.sgallalucas.workshop_mongo.services.PostService;
import com.sgallalucas.workshop_mongo.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDTO>> findAll() {
        List<PostDTO> listDTO = postService.findAll();
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        PostDTO postDTO = postService.findById(id);
        return ResponseEntity.ok().body(postDTO);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<PostDTO> listDTO = postService.searchTitle(text);
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<PostDTO>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        List<PostDTO> listDTO = postService.fullSearch(text, minDate, maxDate);
        return ResponseEntity.ok().body(listDTO);
    }
}
