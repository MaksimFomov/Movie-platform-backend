package com.fomov.movieplatform.mapper.impl;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.mapper.CinemaMapper;
import com.fomov.movieplatform.mapper.EventMapper;
import com.fomov.movieplatform.mapper.MovieMapper;
import com.fomov.movieplatform.model.Cinema;
import com.fomov.movieplatform.model.CinemaDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CinemaMapperImpl implements CinemaMapper {

    private final MovieMapper movieMapper;
    private final EventMapper eventMapper;

    public CinemaMapperImpl(MovieMapper movieMapper, EventMapper eventMapper) {
        this.movieMapper = movieMapper;
        this.eventMapper = eventMapper;
    }

    @Override
    public CinemaDTO cinemaToCinemaDTO(Cinema cinema) {
        if (cinema == null) {
            return null;
        }

        CinemaDTO cinemaDTO = new CinemaDTO();
        cinemaDTO.setId(cinema.getId());
        cinemaDTO.setName(cinema.getName());
        cinemaDTO.setAddress(cinema.getCinemaDetails().getAddress());
        cinemaDTO.setCapacity(cinema.getCinemaDetails().getCapacity());
        cinemaDTO.setMovieDTOs(movieMapper.moviesToMovieDTOs(cinema.getMovies()));
        cinemaDTO.setEventDTOs(eventMapper.eventsToEventDTOs(cinema.getEvents()));

        return cinemaDTO;
    }

    @Override
    public Cinema cinemaDTOToCinema(CinemaDTO cinemaDTO) {
        if (cinemaDTO == null) {
            return null;
        }

        Cinema cinema = new Cinema();
        cinema.setId(cinemaDTO.getId());
        cinema.setName(cinemaDTO.getName());

        CinemaDetails cinemaDetails = new CinemaDetails();
        cinemaDetails.setAddress(cinemaDTO.getAddress());
        cinemaDetails.setCapacity(cinemaDTO.getCapacity());

        cinema.setCinemaDetails(cinemaDetails);
        cinema.setMovies(movieMapper.movieDTOsToMovies(cinemaDTO.getMovieDTOs()));
        cinema.setEvents(eventMapper.eventDTOsToEvents(cinemaDTO.getEventDTOs()));

        return cinema;
    }

    @Override
    public List<CinemaDTO> cinemasToCinemaDTOs(List<Cinema> cinemas) {
        return cinemas.stream()
                .map(this::cinemaToCinemaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cinema> cinemaDTOsToCinemas(List<CinemaDTO> cinemaDTOs) {
        return cinemaDTOs.stream()
                .map(this::cinemaDTOToCinema)
                .collect(Collectors.toList());
    }
}


