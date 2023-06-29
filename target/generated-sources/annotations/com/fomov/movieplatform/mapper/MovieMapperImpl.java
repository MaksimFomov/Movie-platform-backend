package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.MovieDTO;
import com.fomov.movieplatform.model.Genre;
import com.fomov.movieplatform.model.Movie;
import com.fomov.movieplatform.model.MovieDetails;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-29T10:48:51+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Azul Systems, Inc.)"
)
@Component
public class MovieMapperImpl implements MovieMapper {

    @Override
    public Movie toMovie(MovieDTO movieDTO) {
        if ( movieDTO == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setMovieDetails( movieDTOToMovieDetails( movieDTO ) );
        movie.setGenre( movieDTOToGenre( movieDTO ) );
        movie.setId( movieDTO.getId() );
        movie.setName( movieDTO.getName() );

        return movie;
    }

    @Override
    public MovieDTO toMovieDTO(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setDescription( movieMovieDetailsDescription( movie ) );
        movieDTO.setCountry( movieMovieDetailsCountry( movie ) );
        Integer year = movieMovieDetailsYear( movie );
        if ( year != null ) {
            movieDTO.setYear( year );
        }
        movieDTO.setProducer( movieMovieDetailsProducer( movie ) );
        Integer duration = movieMovieDetailsDuration( movie );
        if ( duration != null ) {
            movieDTO.setDuration( duration );
        }
        Integer ageLimit = movieMovieDetailsAgeLimit( movie );
        if ( ageLimit != null ) {
            movieDTO.setAgeLimit( ageLimit );
        }
        movieDTO.setGenreName( movieGenreName( movie ) );
        if ( movie.getId() != null ) {
            movieDTO.setId( movie.getId() );
        }
        movieDTO.setName( movie.getName() );

        return movieDTO;
    }

    @Override
    public List<MovieDTO> toMovieDTOs(List<Movie> movies) {
        if ( movies == null ) {
            return null;
        }

        List<MovieDTO> list = new ArrayList<MovieDTO>( movies.size() );
        for ( Movie movie : movies ) {
            list.add( toMovieDTO( movie ) );
        }

        return list;
    }

    @Override
    public List<Movie> toMovies(List<MovieDTO> movieDTOs) {
        if ( movieDTOs == null ) {
            return null;
        }

        List<Movie> list = new ArrayList<Movie>( movieDTOs.size() );
        for ( MovieDTO movieDTO : movieDTOs ) {
            list.add( toMovie( movieDTO ) );
        }

        return list;
    }

    protected MovieDetails movieDTOToMovieDetails(MovieDTO movieDTO) {
        if ( movieDTO == null ) {
            return null;
        }

        MovieDetails movieDetails = new MovieDetails();

        movieDetails.setDescription( movieDTO.getDescription() );
        movieDetails.setCountry( movieDTO.getCountry() );
        movieDetails.setYear( movieDTO.getYear() );
        movieDetails.setProducer( movieDTO.getProducer() );
        movieDetails.setDuration( movieDTO.getDuration() );
        movieDetails.setAgeLimit( movieDTO.getAgeLimit() );

        return movieDetails;
    }

    protected Genre movieDTOToGenre(MovieDTO movieDTO) {
        if ( movieDTO == null ) {
            return null;
        }

        Genre genre = new Genre();

        genre.setName( movieDTO.getGenreName() );

        return genre;
    }

    private String movieMovieDetailsDescription(Movie movie) {
        if ( movie == null ) {
            return null;
        }
        MovieDetails movieDetails = movie.getMovieDetails();
        if ( movieDetails == null ) {
            return null;
        }
        String description = movieDetails.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    private String movieMovieDetailsCountry(Movie movie) {
        if ( movie == null ) {
            return null;
        }
        MovieDetails movieDetails = movie.getMovieDetails();
        if ( movieDetails == null ) {
            return null;
        }
        String country = movieDetails.getCountry();
        if ( country == null ) {
            return null;
        }
        return country;
    }

    private Integer movieMovieDetailsYear(Movie movie) {
        if ( movie == null ) {
            return null;
        }
        MovieDetails movieDetails = movie.getMovieDetails();
        if ( movieDetails == null ) {
            return null;
        }
        Integer year = movieDetails.getYear();
        if ( year == null ) {
            return null;
        }
        return year;
    }

    private String movieMovieDetailsProducer(Movie movie) {
        if ( movie == null ) {
            return null;
        }
        MovieDetails movieDetails = movie.getMovieDetails();
        if ( movieDetails == null ) {
            return null;
        }
        String producer = movieDetails.getProducer();
        if ( producer == null ) {
            return null;
        }
        return producer;
    }

    private Integer movieMovieDetailsDuration(Movie movie) {
        if ( movie == null ) {
            return null;
        }
        MovieDetails movieDetails = movie.getMovieDetails();
        if ( movieDetails == null ) {
            return null;
        }
        Integer duration = movieDetails.getDuration();
        if ( duration == null ) {
            return null;
        }
        return duration;
    }

    private Integer movieMovieDetailsAgeLimit(Movie movie) {
        if ( movie == null ) {
            return null;
        }
        MovieDetails movieDetails = movie.getMovieDetails();
        if ( movieDetails == null ) {
            return null;
        }
        Integer ageLimit = movieDetails.getAgeLimit();
        if ( ageLimit == null ) {
            return null;
        }
        return ageLimit;
    }

    private String movieGenreName(Movie movie) {
        if ( movie == null ) {
            return null;
        }
        Genre genre = movie.getGenre();
        if ( genre == null ) {
            return null;
        }
        String name = genre.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
