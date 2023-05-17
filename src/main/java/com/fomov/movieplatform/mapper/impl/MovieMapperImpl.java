package com.fomov.movieplatform.mapper.impl;

import com.fomov.movieplatform.dto.MovieDTO;
import com.fomov.movieplatform.mapper.CinemaMapper;
import com.fomov.movieplatform.mapper.EventMapper;
import com.fomov.movieplatform.mapper.GenreMapper;
import com.fomov.movieplatform.mapper.MovieMapper;
import com.fomov.movieplatform.model.Movie;
import com.fomov.movieplatform.model.MovieDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapperImpl implements MovieMapper {

    private final GenreMapper genreMapper;
    private final CinemaMapper cinemaMapper;
    private final EventMapper eventMapper;

    public MovieMapperImpl(GenreMapper genreMapper, CinemaMapper cinemaMapper, EventMapper eventMapper) {
        this.genreMapper = genreMapper;
        this.cinemaMapper = cinemaMapper;
        this.eventMapper = eventMapper;
    }

    @Override
    public MovieDTO movieToMovieDTO(Movie movie) {
        if (movie == null) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setName(movie.getName());
        movieDTO.setDescription(movie.getMovieDetails().getDescription());
        movieDTO.setCountry(movie.getMovieDetails().getCountry());
        movieDTO.setYear(movie.getMovieDetails().getYear());
        movieDTO.setProducer(movie.getMovieDetails().getProducer());
        movieDTO.setDuration(movie.getMovieDetails().getDuration());
        movieDTO.setAgeLimit(movie.getMovieDetails().getAgeLimit());
        movieDTO.setGenreDTO(genreMapper.genreToGenreDTO(movie.getGenre()));
        movieDTO.setCinemaDTOs(cinemaMapper.cinemasToCinemaDTOs(movie.getCinemas()));
        movieDTO.setEventDTOs(eventMapper.eventsToEventDTOs(movie.getEvents()));

        return movieDTO;
    }

    @Override
    public Movie movieDTOToMovie(MovieDTO movieDTO) {
        if (movieDTO == null) {
            return null;
        }

        Movie movie = new Movie();
        movie.setId(movieDTO.getId());
        movie.setName(movieDTO.getName());

        MovieDetails movieDetails = new MovieDetails();
        movieDetails.setDescription(movieDTO.getDescription());
        movieDetails.setCountry(movieDTO.getCountry());
        movieDetails.setYear(movieDTO.getYear());
        movieDetails.setProducer(movieDTO.getProducer());
        movieDetails.setDuration(movieDTO.getDuration());
        movieDetails.setAgeLimit(movieDTO.getAgeLimit());

        movie.setMovieDetails(movieDetails);
        movie.setGenre(genreMapper.genreDTOToGenre(movieDTO.getGenreDTO()));
        movie.setCinemas(cinemaMapper.cinemaDTOsToCinemas(movieDTO.getCinemaDTOs()));
        movie.setEvents(eventMapper.eventDTOsToEvents(movieDTO.getEventDTOs()));

        return movie;
    }

    @Override
    public List<MovieDTO> moviesToMovieDTOs(List<Movie> movies) {
        return movies.stream()
                .map(this::movieToMovieDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Movie> movieDTOsToMovies(List<MovieDTO> movieDTOs) {
        return movieDTOs.stream()
                .map(this::movieDTOToMovie)
                .collect(Collectors.toList());
    }
}


