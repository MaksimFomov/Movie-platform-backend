package com.fomov.movieplatform.facade.impl;

import com.fomov.movieplatform.dto.EventDTO;
import com.fomov.movieplatform.facade.EventFacade;
import com.fomov.movieplatform.mapper.EventMapper;
import com.fomov.movieplatform.model.Event;
import com.fomov.movieplatform.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventFacadeImpl implements EventFacade {
    private final EventService eventService;
    private final EventMapper eventMapper;

    public EventFacadeImpl(EventService eventService, EventMapper eventMapper) {
        this.eventService = eventService;
        this.eventMapper = eventMapper;
    }

    @Override
    public List<EventDTO> getAllEvents() {
        List<Event> receivedEvents = eventService.getAllEvents();
        return eventMapper.toEventDTOs(receivedEvents);
    }

    @Override
    public EventDTO getEventById(Long eventId) {
        Event receivedEvent = eventService.getEventById(eventId);
        return eventMapper.toEventDTO(receivedEvent);
    }

    @Override
    public EventDTO addEvent(EventDTO eventDTO) {
        Event event = eventMapper.toEvent(eventDTO);
        Event addedEvent = eventService.addEvent(event);
        return eventMapper.toEventDTO(addedEvent);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventService.deleteEvent(eventId);
    }

    @Override
    public EventDTO updateEvent(Long eventId, EventDTO eventDTO) {
        Event event = eventMapper.toEvent(eventDTO);
        Event updatedEvent = eventService.updateEvent(eventId, event);
        return eventMapper.toEventDTO(updatedEvent);
    }
}
