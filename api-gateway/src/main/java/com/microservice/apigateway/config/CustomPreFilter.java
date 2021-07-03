package com.microservice.apigateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class CustomPreFilter implements GlobalFilter {
    Logger logger = LoggerFactory.getLogger(CustomPreFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest serverHttpRequest = exchange.getRequest() ;
         return chain.filter(exchange).then(

                    // whatever we write inside then, its the post filter.
                Mono.fromRunnable(() -> {
                    ServerHttpResponse serverHttpResponse = exchange.getResponse() ;
                    logger.info("Post filter: "+serverHttpResponse.getStatusCode()) ;
                })) ;
    }
}
