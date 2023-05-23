package com.fomov.movieplatform.dto;

import java.util.Objects;

public class OrderDTO {
    private Long id;
    private Long eventId;
    private Long userId;

    public OrderDTO() {
    }

    public OrderDTO(Long id, Long eventId, Long userId) {
        this.id = id;
        this.eventId = eventId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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
        return Objects.equals(id, orderDTO.id) && Objects.equals(eventId, orderDTO.eventId) && Objects.equals(userId, orderDTO.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventId, userId);
    }
}


