package com.fomov.movieplatform.facade;

import com.fomov.movieplatform.dto.EventRequestDTO;
import com.fomov.movieplatform.dto.EventResponseDTO;
import com.fomov.movieplatform.model.Event;

import java.util.List;

public interface EventFacade {
    List<EventResponseDTO> getAllEvents();
    EventResponseDTO getEventById(Long eventId);

    EventResponseDTO addEvent(EventRequestDTO eventRequestDTO);
    void deleteEvent(Long eventId);
    EventResponseDTO updateEvent(Long eventId, EventRequestDTO eventRequestDTO);

    List<EventResponseDTO> getAllEventsSortedByDate();
    List<EventResponseDTO> getEventsByCinema(Long cinemaId);
    List<EventResponseDTO> getEventsByMovie(Long movieId);
    List<EventResponseDTO> getEventsByGenre(String genreName);
}
