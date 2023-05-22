package com.fomov.movieplatform.exception.notfound;

public class GenreNotFoundException extends ResourceNotFoundException {
    public GenreNotFoundException(String message) {
        super(message);
    }
}
