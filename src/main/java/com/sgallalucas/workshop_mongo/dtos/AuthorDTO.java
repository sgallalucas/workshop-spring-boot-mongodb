package com.sgallalucas.workshop_mongo.dtos;

import com.sgallalucas.workshop_mongo.domain.User;

import java.io.Serializable;

public class PostAuthorDTO implements Serializable {

    private String id;
    private String name;

    public PostAuthorDTO() {
    }

    public PostAuthorDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
