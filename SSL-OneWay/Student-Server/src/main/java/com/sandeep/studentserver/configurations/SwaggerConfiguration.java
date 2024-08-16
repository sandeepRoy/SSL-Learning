package com.sandeep.studentserver.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(List.of(
                       new Server().url("https://localhost:8081").description("Secured Student Server")
                ));
    }

    @Bean
    public GroupedOpenApi publicAPI() {
        return GroupedOpenApi
                .builder()
                .group("public")
                .pathsToMatch("/student/update/{student_id}", "/student/{student_id}")
                .build();
    }
}
