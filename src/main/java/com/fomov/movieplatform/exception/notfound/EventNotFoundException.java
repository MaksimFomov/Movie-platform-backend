package com.fomov.movieplatform.exception.notfound;

public class EventNotFoundException extends ResourceNotFoundException {
    public EventNotFoundException(String message) {
        super(message);
    }
}
