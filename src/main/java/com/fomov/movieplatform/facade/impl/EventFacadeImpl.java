package com.fomov.movieplatform.facade.impl;

import com.fomov.movieplatform.dto.EventRequestDTO;
import com.fomov.movieplatform.dto.EventResponseDTO;
import com.fomov.movieplatform.facade.EventFacade;
import com.fomov.movieplatform.mapper.EventRequestMapper;
import com.fomov.movieplatform.mapper.EventResponseMapper;
import com.fomov.movieplatform.model.Event;
import com.fomov.movieplatform.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventFacadeImpl implements EventFacade {
    private final EventService eventService;
    private final EventResponseMapper eventResponseMapper;
    private final EventRequestMapper eventRequestMapper;

    public EventFacadeImpl(EventService eventService, EventResponseMapper eventResponseMapper, EventRequestMapper eventRequestMapper) {
        this.eventService = eventService;
        this.eventResponseMapper = eventResponseMapper;
        this.eventRequestMapper = eventRequestMapper;
    }

    @Override
    public List<EventResponseDTO> getAllEvents() {
        List<Event> receivedEvents = eventService.getAllEvents();
        return eventResponseMapper.toEventResponseDTOs(receivedEvents);
    }

    @Override
    public EventResponseDTO getEventById(Long eventId) {
        Event receivedEvent = eventService.getEventById(eventId);
        return eventResponseMapper.toEventResponseDTO(receivedEvent);
    }

    @Override
    public EventResponseDTO addEvent(EventRequestDTO eventRequestDTO) {
        Event event = eventRequestMapper.toEvent(eventRequestDTO);
        Event addedEvent = eventService.addEvent(event);
        return eventResponseMapper.toEventResponseDTO(addedEvent);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventService.deleteEvent(eventId);
    }

    @Override
    public EventResponseDTO updateEvent(Long eventId, EventRequestDTO eventRequestDTO) {
        Event event = eventRequestMapper.toEvent(eventRequestDTO);
        Event updatedEvent = eventService.updateEvent(eventId, event);
        return eventResponseMapper.toEventResponseDTO(updatedEvent);
    }
}
