package com.xulihuazj.blogservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 全局参数
     *
     * @return
     */
    private List<Parameter> parameterList() {
        List<Parameter> params = new ArrayList<>();
        params.add(new ParameterBuilder().name("Authorization")
                .description("Authorization Bearer token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build());
        return params;
    }

    @Bean
    public Docket sysApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xulihuazj.blogservice.api"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(parameterList());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("blog-service api")
                .description("blog-service 微服务")
                .termsOfServiceUrl("")
                .version("1.0").build();
    }


}
