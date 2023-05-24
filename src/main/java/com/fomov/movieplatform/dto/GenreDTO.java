package com.fomov.movieplatform.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GenreDTO {
    private long id;
    private String name;

    public GenreDTO() {
    }

    @JsonIgnore
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



