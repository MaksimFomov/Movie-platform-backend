package com.fomov.movieplatform.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cinema_details")
public class CinemaDetails {
    @Id
    @Column(name = "cinema_id", nullable = false)
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    public CinemaDetails() {
    }

    public CinemaDetails(Long id, String address, Integer capacity, Cinema cinema) {
        this.id = id;
        this.address = address;
        this.capacity = capacity;
        this.cinema = cinema;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaDetails that = (CinemaDetails) o;
        return Objects.equals(id, that.id) && Objects.equals(address, that.address) && Objects.equals(capacity, that.capacity) && Objects.equals(cinema, that.cinema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, capacity, cinema);
    }
}
