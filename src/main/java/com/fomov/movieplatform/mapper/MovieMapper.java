package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.MovieDTO;
import com.fomov.movieplatform.model.Movie;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(target = "movieDetails.description", source = "description")
    @Mapping(target = "movieDetails.country", source = "country")
    @Mapping(target = "movieDetails.year", source = "year")
    @Mapping(target = "movieDetails.producer", source = "producer")
    @Mapping(target = "movieDetails.duration", source = "duration")
    @Mapping(target = "movieDetails.ageLimit", source = "ageLimit")
    @Mapping(target = "genre.name", source = "genreName")
    Movie toMovie(MovieDTO movieDTO);

    @Mapping(target = "description", source = "movieDetails.description")
    @Mapping(target = "country", source = "movieDetails.country")
    @Mapping(target = "year", source = "movieDetails.year")
    @Mapping(target = "producer", source = "movieDetails.producer")
    @Mapping(target = "duration", source = "movieDetails.duration")
    @Mapping(target = "ageLimit", source = "movieDetails.ageLimit")
    @Mapping(target = "genreName", source = "genre.name")
    MovieDTO toMovieDTO(Movie movie);

    @IterableMapping(elementTargetType = MovieDTO.class)
    List<MovieDTO> toMovieDTOs(List<Movie> movies);

    @IterableMapping(elementTargetType = Movie.class)
    List<Movie> toMovies(List<MovieDTO> movieDTOs);
}
