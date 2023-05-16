package com.fomov.movieplatform.dto;

import com.fomov.movieplatform.model.Order;

import java.util.List;

public class EventDTO {
    private Long id;
    private MovieDTO movie;
    private CinemaDTO cinema;
    private double price;
    private int numberOfTickets;
    private List<OrderDTO> orders;

    // constructors, getters and setters
}


