package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.EventDTO;
import com.fomov.movieplatform.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MovieMapper.class, CinemaMapper.class, OrderMapper.class})
public interface EventMapper {

    @Mapping(source = "movie", target = "movieDTO")
    @Mapping(source = "cinema", target = "cinemaDTO")
    @Mapping(source = "orders", target = "orderDTOs")
    EventDTO eventToEventDTO(Event event);

    @Mapping(source = "movieDTO", target = "movie")
    @Mapping(source = "cinemaDTO", target = "cinema")
    @Mapping(source = "orderDTOs", target = "orders")
    Event eventDTOToEvent(EventDTO eventDTO);

    List<EventDTO> eventsToEventDTOs(List<Event> events);

    List<Event> eventDTOsToEvents(List<EventDTO> eventDTOs);
}

