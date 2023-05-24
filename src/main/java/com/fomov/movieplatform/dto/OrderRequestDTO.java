package com.fomov.movieplatform.dto;

public class OrderRequestDTO {
    private long eventId;
    private long userId;

    public OrderRequestDTO() {
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}


