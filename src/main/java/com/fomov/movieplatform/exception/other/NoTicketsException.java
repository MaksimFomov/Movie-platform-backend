package com.fomov.movieplatform.exception.other;

public class NoTicketsException extends RuntimeException {
    public NoTicketsException(String message) {
        super(message);
    }
}
