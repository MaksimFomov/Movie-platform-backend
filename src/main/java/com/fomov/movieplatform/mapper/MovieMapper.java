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
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mappings({
            @Mapping(source = "movieDetails.description", target = "description"),
            @Mapping(source = "movieDetails.country", target = "country"),
            @Mapping(source = "movieDetails.year", target = "year"),
            @Mapping(source = "movieDetails.producer", target = "producer"),
            @Mapping(source = "movieDetails.duration", target = "duration"),
            @Mapping(source = "movieDetails.ageLimit", target = "ageLimit"),
            @Mapping(target = "genreDTO", ignore = true),
            @Mapping(target = "cinemaDTOs", ignore = true),
            @Mapping(target = "eventDTOs", ignore = true)
    })
    MovieDTO toMovieDTO(Movie movie);

    @AfterMapping
    default void setGenreDTO(@MappingTarget MovieDTO movieDTO, Movie movie) {
        movieDTO.setGenreDTO(GenreMapper.INSTANCE.toGenreDTO(movie.getGenre()));
    }

    @AfterMapping
    default void setCinemaDTOs(@MappingTarget MovieDTO movieDTO, Movie movie) {
        movieDTO.setCinemaDTOs(CinemaMapper.INSTANCE.toCinemaDTOs(movie.getCinemas()));
    }

    @AfterMapping
    default void setEventDTOs(@MappingTarget MovieDTO movieDTO, Movie movie) {
        movieDTO.setEventDTOs(EventMapper.INSTANCE.toEventDTOs(movie.getEvents()));
    }

    @Mappings({
            @Mapping(source = "description", target = "movieDetails.description"),
            @Mapping(source = "country", target = "movieDetails.country"),
            @Mapping(source = "year", target = "movieDetails.year"),
            @Mapping(source = "producer", target = "movieDetails.producer"),
            @Mapping(source = "duration", target = "movieDetails.duration"),
            @Mapping(source = "ageLimit", target = "movieDetails.ageLimit")
    })
    Movie toMovie(MovieDTO movieDTO);

    List<MovieDTO> toMovieDTOs(List<Movie> movies);

    default List<Cinema> toCinemas(List<CinemaDTO> cinemaDTOs) {
        return cinemaDTOs.stream()
                .map(CinemaMapper.INSTANCE::toCinema)
                .collect(Collectors.toList());
    }

    default List<Event> toEvents(List<EventDTO> eventDTOs) {
        return eventDTOs.stream()
                .map(EventMapper.INSTANCE::toEvent)
                .collect(Collectors.toList());
    }
}

