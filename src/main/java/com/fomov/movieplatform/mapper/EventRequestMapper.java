package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.EventRequestDTO;
import com.fomov.movieplatform.dto.EventResponseDTO;
import com.fomov.movieplatform.model.Event;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventRequestMapper {
    EventRequestMapper INSTANCE = Mappers.getMapper(EventRequestMapper.class);

    @Mapping(target = "movieId", source = "movie.id")
    @Mapping(target = "cinemaId", source = "cinema.id")
    EventRequestDTO toEventRequestDTO(Event event);

    @Mapping(target = "movie.id", source = "movieId")
    @Mapping(target = "cinema.id", source = "cinemaId")
    Event toEvent(EventRequestDTO eventRequestDTO);

    @IterableMapping(elementTargetType = EventResponseDTO.class)
    List<EventRequestDTO> toEventRequestDTOs(List<Event> events);

    @IterableMapping(elementTargetType = Event.class)
    List<Event> toEvents(List<EventRequestDTO> eventRequestDTOs);
}
