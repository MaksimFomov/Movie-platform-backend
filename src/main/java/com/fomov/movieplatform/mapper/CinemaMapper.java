package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.model.Cinema;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CinemaMapper {
    CinemaMapper INSTANCE = Mappers.getMapper(CinemaMapper.class);

    @Mapping(target = "address", source = "cinemaDetails.address")
    @Mapping(target = "capacity", source = "cinemaDetails.capacity")
    CinemaDTO toCinemaDTO(Cinema cinema);

    @Mapping(target = "cinemaDetails.address", source = "cinemaDTO.address")
    @Mapping(target = "cinemaDetails.capacity", source = "cinemaDTO.capacity")
    Cinema toCinema(CinemaDTO cinemaDTO);

    @IterableMapping(elementTargetType = CinemaDTO.class)
    List<CinemaDTO> toCinemaDTOs(List<Cinema> cinemas);

    @IterableMapping(elementTargetType = Cinema.class)
    List<Cinema> toCinemas(List<CinemaDTO> cinemaDTOs);
}
