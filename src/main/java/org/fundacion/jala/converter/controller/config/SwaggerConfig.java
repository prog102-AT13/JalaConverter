/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Raymundo Guaraguara Sansusty
 */
package org.fundacion.jala.converter.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.Collections;

/**
 * This class configures swagger documentation.
 */
@Configuration
public class SwaggerConfig {
    /**
     * Creates a Docket.
     *
     * @return a Docket with Swagger configuration
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("org.fundacion.jala.converter"))
                .build()
                .apiInfo(apiDetails());
    }

    /**
     * Customizes the API Information.
     *
     * @return the ApiInfo with the customization values
     */
    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Jala Converter",
                "Application that provides the following services:\n"
                        + "\t• Convert audio files.\n"
                        + "\t• Convert video files.\n"
                        + "\t• Extract metadata from files.\n"
                        + "\t• Extract text from images.\n"
                        + "\t• Compile python projects.\n"
                        + "\t• Compile java projects.",
                "1.0.0",
                "localhost:8080/api/termsofservice",
                new springfox.documentation.service.Contact("Team AT13",
                        "https://www.fundacionjala.org", "AT13@fundacion-jala.org"),
                "API license",
                "localhost:8080/api/license",
                Collections.emptyList());
    }
}
