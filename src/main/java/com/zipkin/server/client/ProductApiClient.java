package com.zipkin.server.client;

import com.zipkin.server.model.Product;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface ProductApiClient {

    @GetExchange("/viewAllProducts")
    List<Product> viewAllProducts();

}
