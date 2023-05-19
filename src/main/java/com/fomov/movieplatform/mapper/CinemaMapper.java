package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.model.Cinema;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CinemaMapper {
    CinemaMapper INSTANCE = Mappers.getMapper(CinemaMapper.class);

    @Mapping(source = "cinemaDetails.address", target = "address")
    @Mapping(source = "cinemaDetails.capacity", target = "capacity")
    @Mapping(source = "movies", target = "movieDTOs")
    @Mapping(source = "events", target = "eventDTOs")
    CinemaDTO toCinemaDTO(Cinema cinema);

    @AfterMapping
    default void setMovieDTOs(@MappingTarget CinemaDTO cinemaDTO, Cinema cinema) {
        cinemaDTO.setMovieDTOs(MovieMapper.INSTANCE.toMovieDTOs(cinema.getMovies()));
    }

    @AfterMapping
    default void setEventDTOs(@MappingTarget CinemaDTO cinemaDTO, Cinema cinema) {
        cinemaDTO.setEventDTOs(EventMapper.INSTANCE.toEventDTOs(cinema.getEvents()));
    }

    @Mapping(source = "address", target = "cinemaDetails.address")
    @Mapping(source = "capacity", target = "cinemaDetails.capacity")
    @Mapping(source = "movieDTOs", target = "movies")
    @Mapping(source = "eventDTOs", target = "events")
    Cinema toCinema(CinemaDTO cinemaDTO);

    List<CinemaDTO> toCinemaDTOs(List<Cinema> cinemas);

    List<Cinema> toCinemas(List<CinemaDTO> cinemaDTOs);
}
