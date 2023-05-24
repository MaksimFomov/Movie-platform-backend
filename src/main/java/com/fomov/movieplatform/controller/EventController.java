package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.EventRequestDTO;
import com.fomov.movieplatform.dto.EventResponseDTO;
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
    ResponseEntity<?> getAllEvents() {
        try {
            List<EventResponseDTO> eventResponseDTOS = eventFacade.getAllEvents();
            return ResponseEntity.ok(eventResponseDTOS);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<?> getEventById(@PathVariable Long eventId) {
        try {
            EventResponseDTO eventResponseDTO = eventFacade.getEventById(eventId);
            return ResponseEntity.ok(eventResponseDTO);
        } catch (EventNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    ResponseEntity<?> addEvent(@RequestBody EventRequestDTO eventRequestDTO) {
        try {
            EventResponseDTO addedEvent = eventFacade.addEvent(eventRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedEvent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long eventId) {
        try {
            eventFacade.deleteEvent(eventId);
            return ResponseEntity.ok("Event successfully deleted.");
        } catch (EventNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<?> updateEvent(@PathVariable Long eventId, @RequestBody EventRequestDTO eventRequestDTO) {
        try {
            EventResponseDTO updatedEvent = eventFacade.updateEvent(eventId, eventRequestDTO);
            return ResponseEntity.ok(updatedEvent);
        } catch (EventNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
