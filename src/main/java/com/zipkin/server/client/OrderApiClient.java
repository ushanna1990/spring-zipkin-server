package com.zipkin.server.client;

import com.zipkin.server.model.Order;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface OrderApiClient {

    @GetExchange("/viewAllOrders")
    List<Order> viewAllOrders();

}
