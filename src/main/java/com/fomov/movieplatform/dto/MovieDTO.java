package com.fomov.movieplatform.dto;

import java.util.List;

public class MovieDTO {
    private Long id;
    private String name;
    private MovieDetailsDTO movieDetails;
    private GenreDTO genre;
    List<CinemaDTO> cinemas;
    List<EventDTO> events;

    public MovieDTO() {
    }
}
