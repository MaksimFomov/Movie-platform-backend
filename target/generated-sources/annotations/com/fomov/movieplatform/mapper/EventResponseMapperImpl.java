package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.EventResponseDTO;
import com.fomov.movieplatform.model.Event;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-29T10:21:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Azul Systems, Inc.)"
)
@Component
public class EventResponseMapperImpl implements EventResponseMapper {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private CinemaMapper cinemaMapper;

    @Override
    public EventResponseDTO toEventResponseDTO(Event event) {
        if ( event == null ) {
            return null;
        }

        EventResponseDTO eventResponseDTO = new EventResponseDTO();

        eventResponseDTO.setMovie( movieMapper.toMovieDTO( event.getMovie() ) );
        eventResponseDTO.setCinema( cinemaMapper.toCinemaDTO( event.getCinema() ) );
        if ( event.getId() != null ) {
            eventResponseDTO.setId( event.getId() );
        }
        eventResponseDTO.setEventDateTime( event.getEventDateTime() );
        if ( event.getPrice() != null ) {
            eventResponseDTO.setPrice( event.getPrice() );
        }
        if ( event.getNumberOfTickets() != null ) {
            eventResponseDTO.setNumberOfTickets( event.getNumberOfTickets() );
        }

        return eventResponseDTO;
    }

    @Override
    public Event toEvent(EventResponseDTO eventResponseDTO) {
        if ( eventResponseDTO == null ) {
            return null;
        }

        Event event = new Event();

        event.setMovie( movieMapper.toMovie( eventResponseDTO.getMovie() ) );
        event.setCinema( cinemaMapper.toCinema( eventResponseDTO.getCinema() ) );
        event.setId( eventResponseDTO.getId() );
        event.setEventDateTime( eventResponseDTO.getEventDateTime() );
        event.setPrice( eventResponseDTO.getPrice() );
        event.setNumberOfTickets( eventResponseDTO.getNumberOfTickets() );

        return event;
    }

    @Override
    public List<EventResponseDTO> toEventResponseDTOs(List<Event> events) {
        if ( events == null ) {
            return null;
        }

        List<EventResponseDTO> list = new ArrayList<EventResponseDTO>( events.size() );
        for ( Event event : events ) {
            list.add( toEventResponseDTO( event ) );
        }

        return list;
    }

    @Override
    public List<Event> toEvents(List<EventResponseDTO> eventResponseDTOs) {
        if ( eventResponseDTOs == null ) {
            return null;
        }

        List<Event> list = new ArrayList<Event>( eventResponseDTOs.size() );
        for ( EventResponseDTO eventResponseDTO : eventResponseDTOs ) {
            list.add( toEvent( eventResponseDTO ) );
        }

        return list;
    }
}
