package com.sgallalucas.workshop_mongo.dtos;

import com.sgallalucas.workshop_mongo.domain.Post;

import java.io.Serializable;
import java.time.Instant;

public class PostDTO  implements Serializable {

    private String id;
    private Instant date;
    private String title;
    private String body;

    public PostDTO() {
    }

    public PostDTO(Post entity) {
        id = entity.getId();
        date = entity.getDate();
        title = entity.getTitle();
        body = entity.getBody();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
