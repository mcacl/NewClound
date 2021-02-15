package com.example.providerone.config;

import org.springframework.context.annotation.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 创建时间:2020/10/5
 * 创建人:pmc
 * 描述:
 */
@Configuration
public class CfigSwagger {
    @Bean
    public Docket userApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.example.providerone.ctrl"))//过滤的接口
                .paths(PathSelectors.any()).build();
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("eureka服务端提供者接口平台").description("提供者providerone服务接口").license("Licence Version 1.0").licenseUrl("#").version("1.0").build();
    }
}
