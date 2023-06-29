package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.EventRequestDTO;
import com.fomov.movieplatform.model.Cinema;
import com.fomov.movieplatform.model.Event;
import com.fomov.movieplatform.model.Movie;
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
public class EventRequestMapperImpl implements EventRequestMapper {

    @Override
    public EventRequestDTO toEventRequestDTO(Event event) {
        if ( event == null ) {
            return null;
        }

        EventRequestDTO eventRequestDTO = new EventRequestDTO();

        Long id = eventMovieId( event );
        if ( id != null ) {
            eventRequestDTO.setMovieId( id );
        }
        Long id1 = eventCinemaId( event );
        if ( id1 != null ) {
            eventRequestDTO.setCinemaId( id1 );
        }
        eventRequestDTO.setEventDateTime( event.getEventDateTime() );
        if ( event.getPrice() != null ) {
            eventRequestDTO.setPrice( event.getPrice() );
        }
        if ( event.getNumberOfTickets() != null ) {
            eventRequestDTO.setNumberOfTickets( event.getNumberOfTickets() );
        }

        return eventRequestDTO;
    }

    @Override
    public Event toEvent(EventRequestDTO eventRequestDTO) {
        if ( eventRequestDTO == null ) {
            return null;
        }

        Event event = new Event();

        event.setMovie( eventRequestDTOToMovie( eventRequestDTO ) );
        event.setCinema( eventRequestDTOToCinema( eventRequestDTO ) );
        event.setEventDateTime( eventRequestDTO.getEventDateTime() );
        event.setPrice( eventRequestDTO.getPrice() );
        event.setNumberOfTickets( eventRequestDTO.getNumberOfTickets() );

        return event;
    }

    @Override
    public List<EventRequestDTO> toEventRequestDTOs(List<Event> events) {
        if ( events == null ) {
            return null;
        }

        List<EventRequestDTO> list = new ArrayList<EventRequestDTO>( events.size() );
        for ( Event event : events ) {
            list.add( eventToEventRequestDTO( event ) );
        }

        return list;
    }

    @Override
    public List<Event> toEvents(List<EventRequestDTO> eventRequestDTOs) {
        if ( eventRequestDTOs == null ) {
            return null;
        }

        List<Event> list = new ArrayList<Event>( eventRequestDTOs.size() );
        for ( EventRequestDTO eventRequestDTO : eventRequestDTOs ) {
            list.add( toEvent( eventRequestDTO ) );
        }

        return list;
    }

    private Long eventMovieId(Event event) {
        if ( event == null ) {
            return null;
        }
        Movie movie = event.getMovie();
        if ( movie == null ) {
            return null;
        }
        Long id = movie.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long eventCinemaId(Event event) {
        if ( event == null ) {
            return null;
        }
        Cinema cinema = event.getCinema();
        if ( cinema == null ) {
            return null;
        }
        Long id = cinema.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Movie eventRequestDTOToMovie(EventRequestDTO eventRequestDTO) {
        if ( eventRequestDTO == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setId( eventRequestDTO.getMovieId() );

        return movie;
    }

    protected Cinema eventRequestDTOToCinema(EventRequestDTO eventRequestDTO) {
        if ( eventRequestDTO == null ) {
            return null;
        }

        Cinema cinema = new Cinema();

        cinema.setId( eventRequestDTO.getCinemaId() );

        return cinema;
    }

    protected EventRequestDTO eventToEventRequestDTO(Event event) {
        if ( event == null ) {
            return null;
        }

        EventRequestDTO eventRequestDTO = new EventRequestDTO();

        eventRequestDTO.setEventDateTime( event.getEventDateTime() );
        if ( event.getPrice() != null ) {
            eventRequestDTO.setPrice( event.getPrice() );
        }
        if ( event.getNumberOfTickets() != null ) {
            eventRequestDTO.setNumberOfTickets( event.getNumberOfTickets() );
        }

        return eventRequestDTO;
    }
}
