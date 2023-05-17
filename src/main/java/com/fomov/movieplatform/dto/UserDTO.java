package com.fomov.movieplatform.dto;

import java.util.List;
import java.util.Objects;

public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private List<OrderDTO> orderDTOs;

    public UserDTO() {
    }

    public UserDTO(Long id, String email, String password, List<OrderDTO> orderDTOs) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.orderDTOs = orderDTOs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return Objects.equals(id, userDTO.id) && Objects.equals(email, userDTO.email) && Objects.equals(password, userDTO.password) && Objects.equals(orderDTOs, userDTO.orderDTOs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, orderDTOs);
    }
}

