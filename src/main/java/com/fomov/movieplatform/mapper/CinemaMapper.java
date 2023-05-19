package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.dto.EventDTO;
import com.fomov.movieplatform.dto.MovieDTO;
import com.fomov.movieplatform.model.Cinema;
import com.fomov.movieplatform.model.Event;
import com.fomov.movieplatform.model.Movie;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CinemaMapper {

    CinemaMapper INSTANCE = Mappers.getMapper(CinemaMapper.class);

    @Mappings({
            @Mapping(source = "cinemaDetails.address", target = "address"),
            @Mapping(source = "cinemaDetails.capacity", target = "capacity"),
            @Mapping(target = "movieDTOs", ignore = true),
            @Mapping(target = "eventDTOs", ignore = true)
    })
    CinemaDTO toCinemaDTO(Cinema cinema);

    @AfterMapping
    default void setMovieDTOs(@MappingTarget CinemaDTO cinemaDTO, Cinema cinema) {
        cinemaDTO.setMovieDTOs(MovieMapper.INSTANCE.toMovieDTOs(cinema.getMovies()));
    }

    @AfterMapping
    default void setEventDTOs(@MappingTarget CinemaDTO cinemaDTO, Cinema cinema) {
        cinemaDTO.setEventDTOs(EventMapper.INSTANCE.toEventDTOs(cinema.getEvents()));
    }

    @Mapping(source = "address", target = "cinemaDetails.address")
    @Mapping(source = "capacity", target = "cinemaDetails.capacity")
    Cinema toCinema(CinemaDTO cinemaDTO);

    List<CinemaDTO> toCinemaDTOs(List<Cinema> cinemas);

    default List<Movie> toMovies(List<MovieDTO> movieDTOs) {
        return movieDTOs.stream()
                .map(MovieMapper.INSTANCE::toMovie)
                .collect(Collectors.toList());
    }

    default List<Event> toEvents(List<EventDTO> eventDTOs) {
        return eventDTOs.stream()
                .map(EventMapper.INSTANCE::toEvent)
                .collect(Collectors.toList());
    }
}


