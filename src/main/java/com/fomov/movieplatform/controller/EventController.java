package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.EventDTO;
import com.fomov.movieplatform.exception.notfound.EventNotFoundException;
import com.fomov.movieplatform.facade.EventFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventFacade eventFacade;

    public EventController(EventFacade eventFacade) {
        this.eventFacade = eventFacade;
    }

    @GetMapping
    ResponseEntity<List<EventDTO>> getAllEvents() {
        List<EventDTO> eventDTOs = eventFacade.getAllEvents();
        return ResponseEntity.ok(eventDTOs);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long eventId) {
        EventDTO eventDTO = eventFacade.getEventById(eventId);
        if (eventDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(eventDTO);
    }

    @PostMapping
    ResponseEntity<EventDTO> addEvent(@RequestBody EventDTO eventDTO) {
        EventDTO addedEvent = eventFacade.addEvent(eventDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedEvent);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long eventId) {
        try {
            eventFacade.deleteEvent(eventId);
            return ResponseEntity.ok("Event successfully deleted.");
        } catch (EventNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long eventId, @RequestBody EventDTO eventDTO) {
        try {
            EventDTO updatedEvent = eventFacade.updateEvent(eventId, eventDTO);
            return ResponseEntity.ok(updatedEvent);
        } catch (EventNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
