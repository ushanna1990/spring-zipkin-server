package com.zipkin.server.service;

import com.zipkin.server.client.OrderApiClient;
import com.zipkin.server.client.PaymentApiClient;
import com.zipkin.server.model.Order;
import com.zipkin.server.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZipkinServerService {

    @Autowired
    private OrderApiClient orderApiClient;

    @Autowired
    private PaymentApiClient paymentApiClient;

    @Retryable(value = {Exception.class, RuntimeException.class}, delay = 60000, maxRetries = 3)
    public List<Order> getOrderApiClientData()  {
        return orderApiClient.viewAllOrders();
    }

    @Retryable(value = {Exception.class, RuntimeException.class}, delay = 60000, maxRetries = 3)
    public List<Payment> getPaymentApiClientData()  {
        return paymentApiClient.viewAllPayments();
    }
}
