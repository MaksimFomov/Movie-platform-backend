package com.fomov.movieplatform.dto;

public class EventResponseDTO {
    private Long id;
    private MovieDTO movieDTO;
    private CinemaDTO cinemaDTO;
    private double price;
    private int numberOfTickets;

    public EventResponseDTO() {
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
}


