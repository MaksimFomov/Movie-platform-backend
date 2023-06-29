package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.OrderRequestDTO;
import com.fomov.movieplatform.model.Event;
import com.fomov.movieplatform.model.Order;
import com.fomov.movieplatform.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-29T10:48:51+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Azul Systems, Inc.)"
)
@Component
public class OrderRequestMapperImpl implements OrderRequestMapper {

    @Override
    public OrderRequestDTO toOrderRequestDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();

        Long id = orderEventId( order );
        if ( id != null ) {
            orderRequestDTO.setEventId( id );
        }
        Long id1 = orderUserId( order );
        if ( id1 != null ) {
            orderRequestDTO.setUserId( id1 );
        }

        return orderRequestDTO;
    }

    @Override
    public Order toOrder(OrderRequestDTO orderRequestDTO) {
        if ( orderRequestDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setEvent( orderRequestDTOToEvent( orderRequestDTO ) );
        order.setUser( orderRequestDTOToUser( orderRequestDTO ) );

        return order;
    }

    @Override
    public List<OrderRequestDTO> toOrderRequestDTOs(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderRequestDTO> list = new ArrayList<OrderRequestDTO>( orders.size() );
        for ( Order order : orders ) {
            list.add( toOrderRequestDTO( order ) );
        }

        return list;
    }

    @Override
    public List<Order> toOrders(List<OrderRequestDTO> orderRequestDTOs) {
        if ( orderRequestDTOs == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( orderRequestDTOs.size() );
        for ( OrderRequestDTO orderRequestDTO : orderRequestDTOs ) {
            list.add( toOrder( orderRequestDTO ) );
        }

        return list;
    }

    private Long orderEventId(Order order) {
        if ( order == null ) {
            return null;
        }
        Event event = order.getEvent();
        if ( event == null ) {
            return null;
        }
        Long id = event.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long orderUserId(Order order) {
        if ( order == null ) {
            return null;
        }
        User user = order.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Event orderRequestDTOToEvent(OrderRequestDTO orderRequestDTO) {
        if ( orderRequestDTO == null ) {
            return null;
        }

        Event event = new Event();

        event.setId( orderRequestDTO.getEventId() );

        return event;
    }

    protected User orderRequestDTOToUser(OrderRequestDTO orderRequestDTO) {
        if ( orderRequestDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( orderRequestDTO.getUserId() );

        return user;
    }
}
