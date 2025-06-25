package com.sgallalucas.workshop_mongo.dtos;

import com.sgallalucas.workshop_mongo.domain.Post;
import com.sgallalucas.workshop_mongo.domain.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;
    private List<Post> posts = new ArrayList<>(); // atributo de associação

    public UserDTO(){
    }

    public UserDTO(User entity){
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
