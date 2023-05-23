package com.fomov.movieplatform.facade;

import com.fomov.movieplatform.dto.OrderDTO;

import java.util.List;

public interface OrderFacade {
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Long orderId);
}
