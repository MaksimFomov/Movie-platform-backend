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

    @Mapping(target = "movieDTO", source = "movie")
    @Mapping(target = "cinemaDTO", source = "cinema")
    EventResponseDTO toEventResponseDTO(Event event);

    @Mapping(target = "movie", source = "movieDTO")
    @Mapping(target = "cinema", source = "cinemaDTO")
    Event toEvent(EventResponseDTO eventResponseDTO);

    @IterableMapping(elementTargetType = EventResponseDTO.class)
    List<EventResponseDTO> toEventResponseDTOs(List<Event> events);

    @IterableMapping(elementTargetType = Event.class)
    List<Event> toEvents(List<EventResponseDTO> eventResponseDTOs);
}
