package com.fomov.movieplatform.dto;

import java.util.List;

public class UserResponseDTO {
    private long id;
    private String username;
    private String role;
    private List<OrderRequestDTO> orders;

    public UserResponseDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<OrderRequestDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderRequestDTO> orders) {
        this.orders = orders;
    }
}

