package com.example.consumer.config;

import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 创建时间:2020/10/4
 * 创建人:pmc
 * 描述:
 */
@Configuration
public class BeanConfig {
    @Bean
    @LoadBalanced //
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
