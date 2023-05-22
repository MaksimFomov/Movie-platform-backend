package com.fomov.movieplatform.exception.notfound;

public class CinemaNotFoundException extends ResourceNotFoundException {
    public CinemaNotFoundException(String message) {
        super(message);
    }
}
