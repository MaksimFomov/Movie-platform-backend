package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.EventDTO;
import com.fomov.movieplatform.model.Event;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(source = "movie", target = "movieDTO")
    @Mapping(source = "cinema", target = "cinemaDTO")
    @Mapping(source = "orders", target = "orderDTOs")
    EventDTO toEventDTO(Event event);

    @Mapping(source = "movieDTO", target = "movie")
    @Mapping(source = "cinemaDTO", target = "cinema")
    @Mapping(source = "orderDTOs", target = "orders")
    Event toEvent(EventDTO eventDTO);

    List<EventDTO> toEventDTOs(List<Event> events);

    List<Event> toEvents(List<EventDTO> eventDTOs);

    @AfterMapping
    default void setMovieDTO(@MappingTarget EventDTO eventDTO, Event event) {
        eventDTO.setMovieDTO(MovieMapper.INSTANCE.toMovieDTO(event.getMovie()));
    }

    @AfterMapping
    default void setCinemaDTO(@MappingTarget EventDTO eventDTO, Event event) {
        eventDTO.setCinemaDTO(CinemaMapper.INSTANCE.toCinemaDTO(event.getCinema()));
    }
}
