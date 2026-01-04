package com.zipkin.server.controller;

import com.zipkin.server.model.Product;
import com.zipkin.server.service.ZipkinServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zipkin")
public class ZipkinServerController {

    @Autowired
    private ZipkinServerService zipkinServerService;

    @GetMapping("/productData")
    public ResponseEntity<List<Product>> getPaymentData() {
        return ResponseEntity.ok(zipkinServerService.getProductApiClientData());
    }
}
