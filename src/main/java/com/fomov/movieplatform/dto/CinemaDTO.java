package com.fomov.movieplatform.dto;

import java.util.Objects;

public class CinemaDTO {
    private Long id;
    private String name;
    private String address;
    private int capacity;

    public CinemaDTO() {
    }

    public CinemaDTO(Long id, String name, String address, int capacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaDTO cinemaDTO = (CinemaDTO) o;
        return capacity == cinemaDTO.capacity && Objects.equals(id, cinemaDTO.id) && Objects.equals(name, cinemaDTO.name) && Objects.equals(address, cinemaDTO.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, capacity);
    }
}



