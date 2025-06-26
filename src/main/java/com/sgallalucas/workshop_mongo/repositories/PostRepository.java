package com.sgallalucas.workshop_mongo.repositories;

import com.sgallalucas.workshop_mongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // Query personalizada
    @Query("{'title': {$regex: ?0, $options: 'i'}}")
    List<Post> searchTitle(String text);

    // Query methods (padrão)
    List<Post> findByTitleContainingIgnoreCase(String text);
}
