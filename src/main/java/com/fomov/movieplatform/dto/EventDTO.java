package com.fomov.movieplatform.dto;

import com.fomov.movieplatform.model.Order;

import java.util.List;
import java.util.Objects;

public class EventDTO {
    private Long id;
    private MovieDTO movie;
    private CinemaDTO cinema;
    private double price;
    private int numberOfTickets;
    private List<OrderDTO> orders;

    public EventDTO() {
    }

    public EventDTO(Long id, MovieDTO movie, CinemaDTO cinema, double price, int numberOfTickets, List<OrderDTO> orders) {
        this.id = id;
        this.movie = movie;
        this.cinema = cinema;
        this.price = price;
        this.numberOfTickets = numberOfTickets;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDTO eventDTO = (EventDTO) o;
        return Double.compare(eventDTO.price, price) == 0 && numberOfTickets == eventDTO.numberOfTickets && Objects.equals(id, eventDTO.id) && Objects.equals(movie, eventDTO.movie) && Objects.equals(cinema, eventDTO.cinema) && Objects.equals(orders, eventDTO.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movie, cinema, price, numberOfTickets, orders);
    }
}


