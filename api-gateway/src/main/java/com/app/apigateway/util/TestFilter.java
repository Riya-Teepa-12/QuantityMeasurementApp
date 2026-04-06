package com.app.apigateway.util;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class TestFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(org.springframework.web.server.ServerWebExchange exchange,
                             org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {

        System.out.println("🔥 GATEWAY HIT: " + exchange.getRequest().getURI());

        return chain.filter(exchange);
    }
}