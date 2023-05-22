package com.fomov.movieplatform.facade;

import com.fomov.movieplatform.dto.EventDTO;

import java.util.List;

public interface EventFacade {
    List<EventDTO> getAllEvents();
    EventDTO getEventById(Long eventId);

    EventDTO addEvent(EventDTO eventDTO);
    void deleteEvent(Long eventId);
    EventDTO updateEvent(Long eventId, EventDTO eventDTO);
}
