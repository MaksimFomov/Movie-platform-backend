package com.fomov.movieplatform.service;

import com.fomov.movieplatform.model.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();
    Event getEventById(Long eventId);

    Event addEvent(Event event);
    void deleteEvent(Long eventId);
    Event updateEvent(Long eventId, Event event);

    List<Event> getAllEventsSortedByDate();
    List<Event> getEventsByCinema(Long cinemaId);
    List<Event> getEventsByMovie(Long movieId);
    List<Event> getEventsByGenre(String genreName);
}
