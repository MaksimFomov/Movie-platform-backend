package com.fomov.movieplatform.dto;

import java.util.List;
import java.util.Objects;

public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private List<OrderDTO> orders;

    public UserDTO() {
    }

    public UserDTO(Long id, String email, String password, List<OrderDTO> orders) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.orders = orders;
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

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) && Objects.equals(email, userDTO.email) && Objects.equals(password, userDTO.password) && Objects.equals(orders, userDTO.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, orders);
    }
}

