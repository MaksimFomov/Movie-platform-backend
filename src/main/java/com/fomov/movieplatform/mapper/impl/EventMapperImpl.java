package com.fomov.movieplatform.mapper.impl;

import com.fomov.movieplatform.dto.EventDTO;
import com.fomov.movieplatform.mapper.CinemaMapper;
import com.fomov.movieplatform.mapper.EventMapper;
import com.fomov.movieplatform.mapper.MovieMapper;
import com.fomov.movieplatform.mapper.OrderMapper;
import com.fomov.movieplatform.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapperImpl implements EventMapper {

    private final MovieMapper movieMapper;
    private final CinemaMapper cinemaMapper;
    private final OrderMapper orderMapper;

    @Autowired
    public EventMapperImpl(MovieMapper movieMapper, CinemaMapper cinemaMapper, OrderMapper orderMapper) {
        this.movieMapper = movieMapper;
        this.cinemaMapper = cinemaMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public EventDTO eventToEventDTO(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setMovieDTO(movieMapper.movieToMovieDTO(event.getMovie()));
        eventDTO.setCinemaDTO(cinemaMapper.cinemaToCinemaDTO(event.getCinema()));
        eventDTO.setOrderDTOs(orderMapper.ordersToOrderDTOs(event.getOrders()));
        return eventDTO;
    }

    @Override
    public Event eventDTOToEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setMovie(movieMapper.movieDTOToMovie(eventDTO.getMovieDTO()));
        event.setCinema(cinemaMapper.cinemaDTOToCinema(eventDTO.getCinemaDTO()));
        event.setOrders(orderMapper.orderDTOsToOrders(eventDTO.getOrderDTOs()));
        return event;
    }

    @Override
    public List<EventDTO> eventsToEventDTOs(List<Event> events) {
        return events.stream()
                .map(this::eventToEventDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> eventDTOsToEvents(List<EventDTO> eventDTOs) {
        return eventDTOs.stream()
                .map(this::eventDTOToEvent)
                .collect(Collectors.toList());
    }
}
