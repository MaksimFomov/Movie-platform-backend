package com.fomov.movieplatform.dto;

import java.util.Objects;

public class EventDTO {
    private Long id;
    private MovieDTO movieDTO;
    private CinemaDTO cinemaDTO;
    private double price;
    private int numberOfTickets;

    public EventDTO() {
    }

    public EventDTO(Long id, MovieDTO movieDTO, CinemaDTO cinemaDTO, double price, int numberOfTickets) {
        this.id = id;
        this.movieDTO = movieDTO;
        this.cinemaDTO = cinemaDTO;
        this.price = price;
        this.numberOfTickets = numberOfTickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieDTO getMovieDTO() {
        return movieDTO;
    }

    public void setMovieDTO(MovieDTO movieDTO) {
        this.movieDTO = movieDTO;
    }

    public CinemaDTO getCinemaDTO() {
        return cinemaDTO;
    }

    public void setCinemaDTO(CinemaDTO cinemaDTO) {
        this.cinemaDTO = cinemaDTO;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDTO eventDTO = (EventDTO) o;
        return Double.compare(eventDTO.price, price) == 0 && numberOfTickets == eventDTO.numberOfTickets && Objects.equals(id, eventDTO.id) && Objects.equals(movieDTO, eventDTO.movieDTO) && Objects.equals(cinemaDTO, eventDTO.cinemaDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieDTO, cinemaDTO, price, numberOfTickets);
    }
}


