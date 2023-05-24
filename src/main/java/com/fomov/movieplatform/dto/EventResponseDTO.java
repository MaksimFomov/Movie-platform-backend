package com.fomov.movieplatform.dto;

import java.time.LocalDateTime;

public class EventResponseDTO {
    private long id;
    private MovieDTO movie;
    private CinemaDTO cinema;
    private LocalDateTime eventDateTime;
    private double price;
    private int numberOfTickets;

    public EventResponseDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    public CinemaDTO getCinema() {
        return cinema;
    }

    public void setCinema(CinemaDTO cinema) {
        this.cinema = cinema;
    }

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
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
}


