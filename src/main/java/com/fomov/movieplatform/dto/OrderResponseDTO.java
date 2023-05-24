package com.fomov.movieplatform.dto;

public class OrderResponseDTO {
    private long id;
    private UserResponseDTO user;
    private EventResponseDTO event;

    public OrderResponseDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }

    public EventResponseDTO getEvent() {
        return event;
    }

    public void setEvent(EventResponseDTO event) {
        this.event = event;
    }
}
