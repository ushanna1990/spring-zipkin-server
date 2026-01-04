package com.zipkin.server.service;

import com.zipkin.server.client.ProductApiClient;
import com.zipkin.server.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZipkinServerService {

    @Autowired
    private ProductApiClient productApiClient;

    @Retryable(value = {Exception.class, RuntimeException.class}, delay = 60000, maxRetries = 3)
    public List<Product> getProductApiClientData()  {
        return productApiClient.viewAllProducts();
    }
}
