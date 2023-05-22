package com.fomov.movieplatform.dto;

import java.util.List;
import java.util.Objects;

public class UserDTO {
    private String email;
    private List<OrderDTO> orderDTOs;

    public UserDTO() {
    }

    public UserDTO(String email, List<OrderDTO> orderDTOs) {
        this.email = email;
        this.orderDTOs = orderDTOs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrderDTO> getOrderDTOs() {
        return orderDTOs;
    }

    public void setOrderDTOs(List<OrderDTO> orderDTOs) {
        this.orderDTOs = orderDTOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(email, userDTO.email) && Objects.equals(orderDTOs, userDTO.orderDTOs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, orderDTOs);
    }
}

