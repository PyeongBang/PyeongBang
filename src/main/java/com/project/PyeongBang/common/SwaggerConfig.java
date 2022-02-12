package com.project.PyeongBang.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket            ;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {
    /**
     * Swagger 설정 핵심
     * http://localhost:8082/swagger-ui/  >> 접속 페이지
     **/
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.project.PyeongBang.controller"))
                .paths(PathSelectors.any()) // 현재 RequestMapping으로 할당된 모든 URL 리스트를
                //.paths(PathSelectors.ant("/api/**")) // 그중 /api/** 인 URL들만 필터링
                .build()
                .apiInfo(apiInfo())
                .pathMapping("");
    }

    @SuppressWarnings("deprecation")
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "PB API",
                "API Documentation for PyeongBang",
                "1.0",
                null,
                "DaeHyeon Baek",
                "Created By DaeHyeon Baek",
                null
        );
    }
}
