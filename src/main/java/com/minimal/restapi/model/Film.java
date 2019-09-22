package com.minimal.restapi.model;

public class Film {

    private String name;
    private String director;

    public Film(String name, String director) {
        this.name = name;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }
}
