package com.fomov.movieplatform.dto;

public class OrderResponseDTO {
    private Long id;
    private UserResponseDTO userResponseDTO;
    private EventResponseDTO eventResponseDTO;

    public OrderResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserResponseDTO getUserResponseDTO() {
        return userResponseDTO;
    }

    public void setUserResponseDTO(UserResponseDTO userResponseDTO) {
        this.userResponseDTO = userResponseDTO;
    }

    public EventResponseDTO getEventResponseDTO() {
        return eventResponseDTO;
    }

    public void setEventResponseDTO(EventResponseDTO eventResponseDTO) {
        this.eventResponseDTO = eventResponseDTO;
    }
}
