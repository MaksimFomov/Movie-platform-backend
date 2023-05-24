package com.fomov.movieplatform.exception.other;

public class InvalidLoginCredentialsException extends RuntimeException {
    public InvalidLoginCredentialsException(String message) {
        super(message);
    }
}
