package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.model.Cinema;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MovieMapper.class, EventMapper.class})
public interface CinemaMapper {

    @Mapping(source = "cinemaDetails.address", target = "address")
    @Mapping(source = "cinemaDetails.capacity", target = "capacity")
    @Mapping(source = "movies", target = "movieDTOs")
    @Mapping(source = "events", target = "eventDTOs")
    CinemaDTO cinemaToCinemaDTO(Cinema cinema);

    @Mapping(source = "address", target = "cinemaDetails.address")
    @Mapping(source = "capacity", target = "cinemaDetails.capacity")
    @Mapping(source = "movieDTOs", target = "movies")
    @Mapping(source = "eventDTOs", target = "events")
    Cinema cinemaDTOToCinema(CinemaDTO cinemaDTO);

    List<CinemaDTO> cinemasToCinemaDTOs(List<Cinema> cinemas);

    List<Cinema> cinemaDTOsToCinemas(List<CinemaDTO> cinemaDTOs);
}


