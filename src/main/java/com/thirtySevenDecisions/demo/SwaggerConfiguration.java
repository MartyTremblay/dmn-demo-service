package com.thirtySevenDecisions.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Slf4j
@Configuration
public class SwaggerConfiguration {

    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(
            InMemorySwaggerResourcesProvider defaultResourcesProvider) {
        log.info("loading swagger ui - /static/openapi.yaml");

        return () -> {
            SwaggerResource wsResource = new SwaggerResource();
            wsResource.setName("api1");
            wsResource.setSwaggerVersion("2.0");
            wsResource.setLocation("/static/openapi.yaml");
            log.info("loading swagger ui - /static/openapi.yaml");
            List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get());
            resources.add(wsResource);
            return resources;
        };
    }
}
