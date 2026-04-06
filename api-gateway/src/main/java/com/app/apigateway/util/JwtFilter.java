package com.app.apigateway.util;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

@Component
public class JwtFilter extends AbstractGatewayFilterFactory<JwtFilter.Config> {

    public JwtFilter() {
        super(Config.class);
    }

    public static class Config {
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {

        	  String path = exchange.getRequest().getURI().getPath();
              System.out.println("Gateway hit: " + path);
              if (exchange.getRequest().getMethod().matches("OPTIONS")) {
            	    return chain.filter(exchange);
            	}

              // ✅ 2. Allow public endpoints
              if (path.contains("/auth") || path.contains("/oauth2") || path.contains("/login")) {
                  return chain.filter(exchange);
              }

            String token = exchange.getRequest()
                    .getHeaders()
                    .getFirst("Authorization");

            if (token == null || !token.startsWith("Bearer ")) {
            	exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED);
            	return exchange.getResponse().setComplete();
            }

            return chain.filter(exchange);
        };
    }
}