package com.fomov.movieplatform.mapper.impl;

import com.fomov.movieplatform.dto.MovieDTO;
import com.fomov.movieplatform.mapper.MovieMapper;
import com.fomov.movieplatform.model.Movie;
import com.fomov.movieplatform.model.MovieDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapperImpl implements MovieMapper {

    private final GenreMapper genreMapper;

    public MovieMapperImpl(GenreMapper genreMapper) {
        this.genreMapper = genreMapper;
    }

    @Override
    public MovieDTO movieToMovieDTO(Movie movie) {
        if (movie == null) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setName(movie.getName());

        if (movie.getMovieDetail() != null) {
            movieDTO.setDescription(movie.getMovieDetail().getDescription());
            movieDTO.setCountry(movie.getMovieDetail().getCountry());
            movieDTO.setYear(movie.getMovieDetail().getYear());
            movieDTO.setProducer(movie.getMovieDetail().getProducer());
            movieDTO.setDuration(movie.getMovieDetail().getDuration());
            movieDTO.setAgeLimit(movie.getMovieDetail().getAgeLimit());
        }

        if (movie.getGenre() != null) {
            movieDTO.setGenre(genreMapper.genreToGenreDTO(movie.getGenre()));
        }

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

        MovieDetails movieDetail = new MovieDetails();
        movieDetail.setDescription(movieDTO.getDescription());
        movieDetail.setCountry(movieDTO.getCountry());
        movieDetail.setYear(movieDTO.getYear());
        movieDetail.setProducer(movieDTO.getProducer());
        movieDetail.setDuration(movieDTO.getDuration());
        movieDetail.setAgeLimit(movieDTO.getAgeLimit());
        movie.setMovieDetails(movieDetail);

        if (movieDTO.getGenre() != null) {
            movie.setGenre(genreMapper.genreDTOToGenre(movieDTO.getGenre()));
        }

        return movie;
    }

    @Override
    public List<MovieDTO> moviesToMovieDTOs(List<Movie> movies) {
        if (movies == null) {
            return null;
        }

        return movies.stream()
                .map(this::movieToMovieDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Movie> movieDTOsToMovies(List<MovieDTO> movieDTOs) {
        if (movieDTOs == null) {
            return null;
        }

        return movieDTOs.stream()
                .map(this::movieDTOToMovie)
                .collect(Collectors.toList());
    }
}

