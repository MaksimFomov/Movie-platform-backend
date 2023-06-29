package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.model.Cinema;
import com.fomov.movieplatform.model.CinemaDetails;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-29T10:21:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Azul Systems, Inc.)"
)
@Component
public class CinemaMapperImpl implements CinemaMapper {

    @Override
    public CinemaDTO toCinemaDTO(Cinema cinema) {
        if ( cinema == null ) {
            return null;
        }

        CinemaDTO cinemaDTO = new CinemaDTO();

        cinemaDTO.setAddress( cinemaCinemaDetailsAddress( cinema ) );
        Integer capacity = cinemaCinemaDetailsCapacity( cinema );
        if ( capacity != null ) {
            cinemaDTO.setCapacity( capacity );
        }
        if ( cinema.getId() != null ) {
            cinemaDTO.setId( cinema.getId() );
        }
        cinemaDTO.setName( cinema.getName() );

        return cinemaDTO;
    }

    @Override
    public Cinema toCinema(CinemaDTO cinemaDTO) {
        if ( cinemaDTO == null ) {
            return null;
        }

        Cinema cinema = new Cinema();

        cinema.setCinemaDetails( cinemaDTOToCinemaDetails( cinemaDTO ) );
        cinema.setId( cinemaDTO.getId() );
        cinema.setName( cinemaDTO.getName() );

        return cinema;
    }

    @Override
    public List<CinemaDTO> toCinemaDTOs(List<Cinema> cinemas) {
        if ( cinemas == null ) {
            return null;
        }

        List<CinemaDTO> list = new ArrayList<CinemaDTO>( cinemas.size() );
        for ( Cinema cinema : cinemas ) {
            list.add( toCinemaDTO( cinema ) );
        }

        return list;
    }

    @Override
    public List<Cinema> toCinemas(List<CinemaDTO> cinemaDTOs) {
        if ( cinemaDTOs == null ) {
            return null;
        }

        List<Cinema> list = new ArrayList<Cinema>( cinemaDTOs.size() );
        for ( CinemaDTO cinemaDTO : cinemaDTOs ) {
            list.add( toCinema( cinemaDTO ) );
        }

        return list;
    }

    private String cinemaCinemaDetailsAddress(Cinema cinema) {
        if ( cinema == null ) {
            return null;
        }
        CinemaDetails cinemaDetails = cinema.getCinemaDetails();
        if ( cinemaDetails == null ) {
            return null;
        }
        String address = cinemaDetails.getAddress();
        if ( address == null ) {
            return null;
        }
        return address;
    }

    private Integer cinemaCinemaDetailsCapacity(Cinema cinema) {
        if ( cinema == null ) {
            return null;
        }
        CinemaDetails cinemaDetails = cinema.getCinemaDetails();
        if ( cinemaDetails == null ) {
            return null;
        }
        Integer capacity = cinemaDetails.getCapacity();
        if ( capacity == null ) {
            return null;
        }
        return capacity;
    }

    protected CinemaDetails cinemaDTOToCinemaDetails(CinemaDTO cinemaDTO) {
        if ( cinemaDTO == null ) {
            return null;
        }

        CinemaDetails cinemaDetails = new CinemaDetails();

        cinemaDetails.setAddress( cinemaDTO.getAddress() );
        cinemaDetails.setCapacity( cinemaDTO.getCapacity() );

        return cinemaDetails;
    }
}
