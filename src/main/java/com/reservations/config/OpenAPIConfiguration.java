package com.reservations.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenAPIConfiguration {
    @Bean
    public OpenAPI apiDetails() {

        return new OpenAPI()
                .info(new Info()
                        .title("Reservation Service")
                        .description("This service is used to demonstrate some spring concepts like the repository pattern and paging")
                        .version("v1.0.0"));

    }
}