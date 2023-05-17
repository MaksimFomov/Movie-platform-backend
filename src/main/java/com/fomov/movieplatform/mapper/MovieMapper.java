package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.MovieDTO;
import com.fomov.movieplatform.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MovieMapper {
    @Mapping(source = "genre", target = "genreDTO")
    @Mapping(source = "cinemas", target = "cinemaDTOs")
    @Mapping(source = "events", target = "eventDTOs")
    @Mapping(source = "movieDetail.description", target = "description")
    @Mapping(source = "movieDetail.country", target = "country")
    @Mapping(source = "movieDetail.year", target = "year")
    @Mapping(source = "movieDetail.producer", target = "producer")
    @Mapping(source = "movieDetail.duration", target = "duration")
    @Mapping(source = "movieDetail.ageLimit", target = "ageLimit")
    MovieDTO movieToMovieDTO(Movie movie);

    @Mapping(source = "genreDTO", target = "genre")
    @Mapping(source = "cinemaDTOs", target = "cinemas")
    @Mapping(source = "eventDTOs", target = "events")
    @Mapping(source = "description", target = "movieDetail.description")
    @Mapping(source = "country", target = "movieDetail.country")
    @Mapping(source = "year", target = "movieDetail.year")
    @Mapping(source = "producer", target = "movieDetail.producer")
    @Mapping(source = "duration", target = "movieDetail.duration")
    @Mapping(source = "ageLimit", target = "movieDetail.ageLimit")
    Movie movieDTOToMovie(MovieDTO movieDTO);

    List<MovieDTO> moviesToMovieDTOs(List<Movie> movies);

    List<Movie> movieDTOsToMovies(List<MovieDTO> movieDTOs);
}

