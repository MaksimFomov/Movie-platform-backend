package com.fomov.movieplatform.dto;

import java.util.List;

public class UserResponseDTO {
    private String username;
    private String role;
    private List<OrderRequestDTO> orderRequestDTOS;

    public UserResponseDTO() {
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

    public List<OrderRequestDTO> getOrderDTOs() {
        return orderRequestDTOS;
    }

    public void setOrderDTOs(List<OrderRequestDTO> orderRequestDTOS) {
        this.orderRequestDTOS = orderRequestDTOS;
    }
}

