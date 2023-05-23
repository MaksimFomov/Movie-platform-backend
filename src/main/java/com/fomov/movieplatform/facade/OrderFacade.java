package com.fomov.movieplatform.facade;

import com.fomov.movieplatform.dto.OrderResponseDTO;

import java.util.List;

public interface OrderFacade {
    List<OrderResponseDTO> getAllOrders();
    OrderResponseDTO getOrderById(Long orderId);
}
