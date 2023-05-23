package com.fomov.movieplatform.dto;

import java.util.Objects;

public class AuthenticationResponseDTO {
    private String token;

    public AuthenticationResponseDTO() {
    }

    public AuthenticationResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthenticationResponseDTO that = (AuthenticationResponseDTO) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}

