package com.fomov.movieplatform.mapper.impl;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.mapper.CinemaMapper;
import com.fomov.movieplatform.model.Cinema;
import com.fomov.movieplatform.model.CinemaDetails;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public class CinemaMapperImpl implements CinemaMapper {

    @Override
    public CinemaDTO cinemaToCinemaDTO(Cinema cinema) {
        if ( cinema == null ) {
            return null;
        }

        CinemaDTO cinemaDTO = new CinemaDTO();

        cinemaDTO.setId( cinema.getId() );
        cinemaDTO.setName( cinema.getName() );

        if ( cinema.getCinemaDetails() != null ) {
            cinemaDTO.setAddress( cinema.getCinemaDetails().getAddress() );
            cinemaDTO.setCapacity( cinema.getCinemaDetails().getCapacity() );
        }

        return cinemaDTO;
    }

    @Override
    public Cinema cinemaDTOToCinema(CinemaDTO cinemaDTO) {
        if ( cinemaDTO == null ) {
            return null;
        }

        Cinema cinema = new Cinema();

        cinema.setId( cinemaDTO.getId() );
        cinema.setName( cinemaDTO.getName() );

        CinemaDetails cinemaDetails = new CinemaDetails();
        cinemaDetails.setAddress( cinemaDTO.getAddress() );
        cinemaDetails.setCapacity( cinemaDTO.getCapacity() );

        cinema.setCinemaDetails( cinemaDetails );

        return cinema;
    }
}
