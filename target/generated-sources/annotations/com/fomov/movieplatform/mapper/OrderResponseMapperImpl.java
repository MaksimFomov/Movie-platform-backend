package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.OrderResponseDTO;
import com.fomov.movieplatform.model.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-29T10:48:51+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Azul Systems, Inc.)"
)
@Component
public class OrderResponseMapperImpl implements OrderResponseMapper {

    @Autowired
    private UserResponseMapper userResponseMapper;
    @Autowired
    private EventResponseMapper eventResponseMapper;

    @Override
    public OrderResponseDTO toOrderResponseDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

        orderResponseDTO.setUser( userResponseMapper.toUserResponseDTO( order.getUser() ) );
        orderResponseDTO.setEvent( eventResponseMapper.toEventResponseDTO( order.getEvent() ) );
        if ( order.getId() != null ) {
            orderResponseDTO.setId( order.getId() );
        }

        return orderResponseDTO;
    }

    @Override
    public Order toOrder(OrderResponseDTO orderResponseDTO) {
        if ( orderResponseDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setUser( userResponseMapper.toUser( orderResponseDTO.getUser() ) );
        order.setEvent( eventResponseMapper.toEvent( orderResponseDTO.getEvent() ) );
        order.setId( orderResponseDTO.getId() );

        return order;
    }

    @Override
    public List<OrderResponseDTO> toOrderResponseDTOs(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderResponseDTO> list = new ArrayList<OrderResponseDTO>( orders.size() );
        for ( Order order : orders ) {
            list.add( toOrderResponseDTO( order ) );
        }

        return list;
    }

    @Override
    public List<Order> toOrders(List<OrderResponseDTO> orderResponseDTOs) {
        if ( orderResponseDTOs == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( orderResponseDTOs.size() );
        for ( OrderResponseDTO orderResponseDTO : orderResponseDTOs ) {
            list.add( toOrder( orderResponseDTO ) );
        }

        return list;
    }
}
