package com.fomov.movieplatform.exception.notfound;

public class MovieNotFoundException extends ResourceNotFoundException {
    public MovieNotFoundException(String message) {
        super(message);
    }
}
