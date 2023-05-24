package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.OrderResponseDTO;
import com.fomov.movieplatform.exception.notfound.OrderNotFoundException;
import com.fomov.movieplatform.facade.OrderFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderFacade orderFacade;

    public OrderController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @GetMapping
    ResponseEntity<?> getAllOrders() {
        try {
            List<OrderResponseDTO> orderResponseDTOs = orderFacade.getAllOrders();
            return ResponseEntity.ok(orderResponseDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Long orderId) {
        try {
            OrderResponseDTO orderResponseDTO = orderFacade.getOrderById(orderId);
            return ResponseEntity.ok(orderResponseDTO);
        } catch (OrderNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
