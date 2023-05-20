package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.EventDTO;
import com.fomov.movieplatform.model.Event;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MovieMapper.class, CinemaMapper.class})
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(target = "movieDTO", source = "movie")
    @Mapping(target = "cinemaDTO", source = "cinema")
    EventDTO toEventDTO(Event event);

    @Mapping(target = "movie", source = "movieDTO")
    @Mapping(target = "cinema", source = "cinemaDTO")
    Event toEvent(EventDTO eventDTO);

    @IterableMapping(elementTargetType = EventDTO.class)
    List<EventDTO> toEventDTOs(List<Event> events);

    @IterableMapping(elementTargetType = Event.class)
    List<Event> toEvents(List<EventDTO> eventDTOs);
}
