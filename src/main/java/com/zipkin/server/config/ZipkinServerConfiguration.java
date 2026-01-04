package com.zipkin.server.config;

import com.zipkin.server.client.ProductApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ZipkinServerConfiguration {

    @Value("${application.product.service.url}")
    public String productServiceUrl;

    @Bean
    public ProductApiClient productApiClient(RestClient.Builder restClientBuilder) {

        RestClient restClient = restClientBuilder.baseUrl(productServiceUrl).build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient)).build();

        return factory.createClient(ProductApiClient.class);
    }

    @Bean
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }
}
