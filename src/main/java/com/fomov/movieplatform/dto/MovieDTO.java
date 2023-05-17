package com.fomov.movieplatform.dto;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MovieDTO {
    private Long id;
    private String name;
    private String description;
    private String country;
    private int year;
    private String producer;
    private int duration;
    private int ageLimit;
    private GenreDTO genre;
    private List<CinemaDTO> cinemas;
    private List<EventDTO> events;

    public MovieDTO() {
    }

    public MovieDTO(Long id, String name, String description, String country, int year, String producer, int duration, int ageLimit, GenreDTO genre, List<CinemaDTO> cinemas, List<EventDTO> events) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.country = country;
        this.year = year;
        this.producer = producer;
        this.duration = duration;
        this.ageLimit = ageLimit;
        this.genre = genre;
        this.cinemas = cinemas;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public GenreDTO getGenre() {
        return genre;
    }

    public void setGenre(GenreDTO genre) {
        this.genre = genre;
    }

    public List<CinemaDTO> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<CinemaDTO> cinemas) {
        this.cinemas = cinemas;
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
        MovieDTO movieDTO = (MovieDTO) o;
        return year == movieDTO.year && duration == movieDTO.duration && ageLimit == movieDTO.ageLimit && Objects.equals(id, movieDTO.id) && Objects.equals(name, movieDTO.name) && Objects.equals(description, movieDTO.description) && Objects.equals(country, movieDTO.country) && Objects.equals(producer, movieDTO.producer) && Objects.equals(genre, movieDTO.genre) && Objects.equals(cinemas, movieDTO.cinemas) && Objects.equals(events, movieDTO.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, country, year, producer, duration, ageLimit, genre, cinemas, events);
    }
}




