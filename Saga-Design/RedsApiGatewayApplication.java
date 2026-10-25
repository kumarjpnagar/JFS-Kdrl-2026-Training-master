package com.honeywell.redsapigateway;

import com.honeywell.redsapigateway.filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class RedsApiGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(RedsApiGatewayApplication.class, args);
  }

  @Bean
  RouteFilter authHeaderFilter() {
    return new RouteFilter();
  }
}
