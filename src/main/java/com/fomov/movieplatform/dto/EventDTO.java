package com.fomov.movieplatform.dto;

import com.fomov.movieplatform.model.Order;

import java.util.List;
import java.util.Objects;

public class EventDTO {
    private Long id;
    private MovieDTO movieDTO;
    private CinemaDTO cinemaDTO;
    private double price;
    private int numberOfTickets;
    private List<OrderDTO> orderDTOs;

    public EventDTO() {
    }

    public EventDTO(Long id, MovieDTO movieDTO, CinemaDTO cinemaDTO, double price, int numberOfTickets, List<OrderDTO> orderDTOs) {
        this.id = id;
        this.movieDTO = movieDTO;
        this.cinemaDTO = cinemaDTO;
        this.price = price;
        this.numberOfTickets = numberOfTickets;
        this.orderDTOs = orderDTOs;
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

    public List<OrderDTO> getOrderDTOs() {
        return orderDTOs;
    }

    public void setOrderDTOs(List<OrderDTO> orderDTOs) {
        this.orderDTOs = orderDTOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDTO eventDTO = (EventDTO) o;
        return Double.compare(eventDTO.price, price) == 0 && numberOfTickets == eventDTO.numberOfTickets && Objects.equals(id, eventDTO.id) && Objects.equals(movieDTO, eventDTO.movieDTO) && Objects.equals(cinemaDTO, eventDTO.cinemaDTO) && Objects.equals(orderDTOs, eventDTO.orderDTOs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieDTO, cinemaDTO, price, numberOfTickets, orderDTOs);
    }
}


