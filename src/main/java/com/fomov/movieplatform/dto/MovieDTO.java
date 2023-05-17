package com.fomov.movieplatform.dto;

import java.util.List;
import java.util.Objects;

public class MovieDTO {
    private Long id;
    private String name;
    private String description;
    private String country;
    private int year;
    private String producer;
    private int duration;
    private int ageLimit;
    private GenreDTO genreDTO;
    private List<CinemaDTO> cinemaDTOs;
    private List<EventDTO> eventDTOs;

    public MovieDTO() {
    }

    public MovieDTO(Long id, String name, String description, String country, int year, String producer, int duration, int ageLimit, GenreDTO genreDTO, List<CinemaDTO> cinemaDTOs, List<EventDTO> eventDTOs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.country = country;
        this.year = year;
        this.producer = producer;
        this.duration = duration;
        this.ageLimit = ageLimit;
        this.genreDTO = genreDTO;
        this.cinemaDTOs = cinemaDTOs;
        this.eventDTOs = eventDTOs;
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

    public GenreDTO getGenreDTO() {
        return genreDTO;
    }

    public void setGenreDTO(GenreDTO genreDTO) {
        this.genreDTO = genreDTO;
    }

    public List<CinemaDTO> getCinemaDTOs() {
        return cinemaDTOs;
    }

    public void setCinemaDTOs(List<CinemaDTO> cinemaDTOs) {
        this.cinemaDTOs = cinemaDTOs;
    }

    public List<EventDTO> getEventDTOs() {
        return eventDTOs;
    }

    public void setEventDTOs(List<EventDTO> eventDTOs) {
        this.eventDTOs = eventDTOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return year == movieDTO.year && duration == movieDTO.duration && ageLimit == movieDTO.ageLimit && Objects.equals(id, movieDTO.id) && Objects.equals(name, movieDTO.name) && Objects.equals(description, movieDTO.description) && Objects.equals(country, movieDTO.country) && Objects.equals(producer, movieDTO.producer) && Objects.equals(genreDTO, movieDTO.genreDTO) && Objects.equals(cinemaDTOs, movieDTO.cinemaDTOs) && Objects.equals(eventDTOs, movieDTO.eventDTOs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, country, year, producer, duration, ageLimit, genreDTO, cinemaDTOs, eventDTOs);
    }
}




