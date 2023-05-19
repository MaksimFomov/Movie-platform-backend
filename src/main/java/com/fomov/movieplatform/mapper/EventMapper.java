package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.EventDTO;
import com.fomov.movieplatform.dto.OrderDTO;
import com.fomov.movieplatform.model.Event;
import com.fomov.movieplatform.model.Order;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mappings({
            @Mapping(target = "movieDTO", ignore = true),
            @Mapping(target = "cinemaDTO", ignore = true),
            @Mapping(target = "orderDTOs", ignore = true)
    })
    EventDTO toEventDTO(Event event);

    @AfterMapping
    default void setMovieDTO(@MappingTarget EventDTO eventDTO, Event event) {
        eventDTO.setMovieDTO(MovieMapper.INSTANCE.toMovieDTO(event.getMovie()));
    }

    @AfterMapping
    default void setCinemaDTO(@MappingTarget EventDTO eventDTO, Event event) {
        eventDTO.setCinemaDTO(CinemaMapper.INSTANCE.toCinemaDTO(event.getCinema()));
    }

    Event toEvent(EventDTO eventDTO);

    List<EventDTO> toEventDTOs(List<Event> events);

    default List<Order> toOrders(List<OrderDTO> orderDTOs) {
        return orderDTOs.stream()
                .map(OrderMapper.INSTANCE::toOrder)
                .collect(Collectors.toList());
    }
}


