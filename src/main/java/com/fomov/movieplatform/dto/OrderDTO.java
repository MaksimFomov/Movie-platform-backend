package com.fomov.movieplatform.dto;

import java.util.Objects;

public class OrderDTO {
    private Long id;
    private UserDTO user;
    private EventDTO event;
    private Integer place;

    public OrderDTO() {
    }

    public OrderDTO(Long id, UserDTO user, EventDTO event, Integer place) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.place = place;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id) && Objects.equals(user, orderDTO.user) && Objects.equals(event, orderDTO.event) && Objects.equals(place, orderDTO.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, event, place);
    }
}


