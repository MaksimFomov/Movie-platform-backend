package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.EventResponseDTO;
import com.fomov.movieplatform.model.Event;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MovieMapper.class, CinemaMapper.class})
public interface EventResponseMapper {
    EventResponseMapper INSTANCE = Mappers.getMapper(EventResponseMapper.class);

    @Mapping(target = "movie", source = "movie")
    @Mapping(target = "cinema", source = "cinema")
    EventResponseDTO toEventResponseDTO(Event event);

    @Mapping(target = "movie", source = "movie")
    @Mapping(target = "cinema", source = "cinema")
    Event toEvent(EventResponseDTO eventResponseDTO);

    @IterableMapping(elementTargetType = EventResponseDTO.class)
    List<EventResponseDTO> toEventResponseDTOs(List<Event> events);

    @IterableMapping(elementTargetType = Event.class)
    List<Event> toEvents(List<EventResponseDTO> eventResponseDTOs);
}
