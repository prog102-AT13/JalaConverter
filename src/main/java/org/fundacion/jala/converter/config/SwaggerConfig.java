package org.fundacion.jala.converter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("org.fundacion.jala.converter"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Jala Converter",
                "Application that provides the following services:\n" +
                        "Convert audio files.\n" +
                        "Convert video files.\n" +
                        "Extract metadata from files.\n" +
                        "Extract text from images.\n" +
                        "Compiles python projects.\n" +
                        "Compiles java projects.",
                "1.0.0",
                "localhost:8080/termsofservice",
                new springfox.documentation.service.Contact("Team AT13", "https://www.fundacionjala.org", "AT13@fundacion-jala.org"),
                "API license",
                "localhost:8080/license",
                Collections.emptyList());
    }
}
