package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.model.Cinema;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CinemaMapper {
    @Mapping(source = "cinemaDetails.address", target = "address")
    @Mapping(source = "cinemaDetails.capacity", target = "capacity")
    CinemaDTO cinemaToCinemaDTO(Cinema cinema);

    @Mapping(source = "address", target = "cinemaDetails.address")
    @Mapping(source = "capacity", target = "cinemaDetails.capacity")
    Cinema cinemaDTOToCinema(CinemaDTO cinemaDTO);
}
