package com.fomov.movieplatform.dto;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CinemaDTO {
    private Long id;
    private String name;
    private String address;
    private int capacity;
    private List<MovieDTO> movies;
    private List<EventDTO> events;

    public CinemaDTO() {
    }

    public CinemaDTO(Long id, String name, String address, int capacity, List<MovieDTO> movies, List<EventDTO> events) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.movies = movies;
        this.events = events;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }

    public List<EventDTO> getEvents() {
        return events;
    }

    public void setEvents(List<EventDTO> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaDTO cinemaDTO = (CinemaDTO) o;
        return capacity == cinemaDTO.capacity && Objects.equals(id, cinemaDTO.id) && Objects.equals(name, cinemaDTO.name) && Objects.equals(address, cinemaDTO.address) && Objects.equals(movies, cinemaDTO.movies) && Objects.equals(events, cinemaDTO.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, capacity, movies, events);
    }
}



