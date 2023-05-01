package com.springboot.security.learning.oauth.model;

public class Hero {
    private final Integer id;

    private final String name;

    public Hero(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
