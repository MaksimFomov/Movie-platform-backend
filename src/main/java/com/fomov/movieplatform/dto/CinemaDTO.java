package com.fomov.movieplatform.dto;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CinemaDTO {
    private Long id;
    private String name;
    private String address;
    private int capacity;
    private List<MovieDTO> movieDTOs;
    private List<EventDTO> eventDTOs;

    public CinemaDTO() {
    }

    public CinemaDTO(Long id, String name, String address, int capacity, List<MovieDTO> movieDTOs, List<EventDTO> eventDTOs) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.movieDTOs = movieDTOs;
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

    public List<MovieDTO> getMovieDTOs() {
        return movieDTOs;
    }

    public void setMovieDTOs(List<MovieDTO> movieDTOs) {
        this.movieDTOs = movieDTOs;
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
        CinemaDTO cinemaDTO = (CinemaDTO) o;
        return capacity == cinemaDTO.capacity && Objects.equals(id, cinemaDTO.id) && Objects.equals(name, cinemaDTO.name) && Objects.equals(address, cinemaDTO.address) && Objects.equals(movieDTOs, cinemaDTO.movieDTOs) && Objects.equals(eventDTOs, cinemaDTO.eventDTOs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, capacity, movieDTOs, eventDTOs);
    }
}



