package com.fomov.movieplatform.service.impl;

import com.fomov.movieplatform.exception.notfound.CinemaNotFoundException;
import com.fomov.movieplatform.exception.notfound.EventNotFoundException;
import com.fomov.movieplatform.exception.notfound.GenreNotFoundException;
import com.fomov.movieplatform.exception.notfound.MovieNotFoundException;
import com.fomov.movieplatform.model.Event;
import com.fomov.movieplatform.repository.EventRepository;
import com.fomov.movieplatform.service.EventService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event not found with ID: " + eventId));
    }

    @Transactional
    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    @Transactional
    @Override
    public void deleteEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event not found with ID: " + eventId));

        eventRepository.delete(event);
    }

    @Transactional
    @Override
    public Event updateEvent(Long eventId, Event event) {
        Event updatedEvent = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event not found with ID: " + event));

        updatedEvent.setMovie(event.getMovie());
        updatedEvent.setCinema(event.getCinema());
        updatedEvent.setPrice(event.getPrice());
        updatedEvent.setNumberOfTickets(event.getNumberOfTickets());
        updatedEvent.setOrders(event.getOrders());

        return eventRepository.save(updatedEvent);
    }

    @Override
    public List<Event> getAllEventsSortedByDate() {
        List<Event> events = eventRepository.findAll();
        events.sort(Comparator.comparing(Event::getEventDateTime));
        return events;
    }

    @Override
    public List<Event> getEventsByCinema(Long cinemaId) {
        return eventRepository.findAllByCinemaId(cinemaId)
                .orElseThrow(() -> new CinemaNotFoundException("Cinema not found with ID: " + cinemaId));
    }

    @Override
    public List<Event> getEventsByMovie(Long movieId) {
        return eventRepository.findAllByMovieId(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with ID: " + movieId));
    }

    @Override
    public List<Event> getEventsByGenre(String genreName) {
        return eventRepository.findAllByMovieGenre_Name(genreName)
                .orElseThrow(() -> new GenreNotFoundException("Genre not found with name: " + genreName));
    }
}
