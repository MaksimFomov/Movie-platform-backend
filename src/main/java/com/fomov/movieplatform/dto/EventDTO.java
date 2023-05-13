package com.fomov.movieplatform.dto;

import com.fomov.movieplatform.model.Order;

import java.util.List;

public class EventDTO {
    private Long id;
    private MovieDTO movie;
    private CinemaDTO cinema;
    private Double price;
    private String numberOfTickets;
    private List<OrderDTO> orders;

    public EventDTO() {
    }
}
