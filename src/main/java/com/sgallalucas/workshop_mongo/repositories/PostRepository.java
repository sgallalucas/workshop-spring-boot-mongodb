package com.sgallalucas.workshop_mongo.repositories;

import com.sgallalucas.workshop_mongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // Query methods
    List<Post> findByTitleContainingIgnoreCase(String text);
}
