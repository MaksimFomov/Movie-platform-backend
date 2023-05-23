package com.fomov.movieplatform.dto;

import java.util.Objects;

public class OrderDTO {
    private Long id;
    private EventDTO eventDTO;
    private Integer place;
    private Long userId;

    public OrderDTO() {
    }

    public OrderDTO(Long id, EventDTO eventDTO, Integer place, Long userId) {
        this.id = id;
        this.eventDTO = eventDTO;
        this.place = place;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventDTO getEventDTO() {
        return eventDTO;
    }

    public void setEventDTO(EventDTO eventDTO) {
        this.eventDTO = eventDTO;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id) && Objects.equals(eventDTO, orderDTO.eventDTO) && Objects.equals(place, orderDTO.place) && Objects.equals(userId, orderDTO.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventDTO, place, userId);
    }
}


