package com.fomov.movieplatform.dto;

import java.util.List;
import java.util.Objects;

public class GenreDTO {
    private Long id;
    private String name;
    private List<MovieDTO> movies;

    public GenreDTO() {
    }

    public GenreDTO(Long id, String name, List<MovieDTO> movies) {
        this.id = id;
        this.name = name;
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreDTO genreDTO = (GenreDTO) o;
        return Objects.equals(id, genreDTO.id) && Objects.equals(name, genreDTO.name) && Objects.equals(movies, genreDTO.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, movies);
    }
}



