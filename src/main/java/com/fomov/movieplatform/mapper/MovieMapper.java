package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.MovieDTO;
import com.fomov.movieplatform.model.Movie;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(source = "movieDetails.description", target = "description")
    @Mapping(source = "movieDetails.country", target = "country")
    @Mapping(source = "movieDetails.year", target = "year")
    @Mapping(source = "movieDetails.producer", target = "producer")
    @Mapping(source = "movieDetails.duration", target = "duration")
    @Mapping(source = "movieDetails.ageLimit", target = "ageLimit")
    @Mapping(source = "genre.name", target = "genreName")
    @Mapping(target = "cinemaDTOs", ignore = true)
    @Mapping(target = "eventDTOs", ignore = true)
    MovieDTO toMovieDTO(Movie movie);

    @AfterMapping
    default void setCinemaDTOs(@MappingTarget MovieDTO movieDTO, Movie movie) {
        movieDTO.setCinemaDTOs(CinemaMapper.INSTANCE.toCinemaDTOs(movie.getCinemas()));
    }

    @AfterMapping
    default void setEventDTOs(@MappingTarget MovieDTO movieDTO, Movie movie) {
        movieDTO.setEventDTOs(EventMapper.INSTANCE.toEventDTOs(movie.getEvents()));
    }

    @Mapping(source = "description", target = "movieDetails.description")
    @Mapping(source = "country", target = "movieDetails.country")
    @Mapping(source = "year", target = "movieDetails.year")
    @Mapping(source = "producer", target = "movieDetails.producer")
    @Mapping(source = "duration", target = "movieDetails.duration")
    @Mapping(source = "ageLimit", target = "movieDetails.ageLimit")
    @Mapping(source = "genreName", target = "genre.name")
    Movie toMovie(MovieDTO movieDTO);

    List<MovieDTO> toMovieDTOs(List<Movie> movies);

    List<Movie> toMovies(List<MovieDTO> movieDTOs);
}
