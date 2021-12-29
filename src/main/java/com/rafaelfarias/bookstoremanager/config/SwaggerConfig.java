package com.rafaelfarias.bookstoremanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Timestamp;
import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String BASE_PACKAGE = "com.rafaelfarias.bookstoremanager";
    private static final String API_TITLE = "API Bookstore Manager";
    private static final String API_DESCRIPION = "Bookstore API Description";
    private static final String API_VERSION = "1.0.0";
    private static final String CONTACT_NAME = "Rafael Farias";
    private static final String CONTACT_GITHUB = "https://github.com/rpfarias";
    private static final String CONTACT_EMAIL = "rpf1rafael@gmail.com";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("API")
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
//                .securitySchemes(Arrays.asList(apiKey()))
//                .securityContexts(Arrays.asList(securityContext()))
                .apiInfo(apiEndPointsInfo()).directModelSubstitute(Timestamp.class, Long.class);
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPION)
                .version(API_VERSION)
                .contact(new Contact(CONTACT_NAME,CONTACT_GITHUB, CONTACT_EMAIL))
                .build();
    }
}
