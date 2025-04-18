package cn.seifly.module.wp.web.config;

import cn.seifly.common.config.JavaPressConfig;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;
import java.util.Map;

/**
 * OpenAPI配置类
 * 用于配置OpenAPI的相关属性，以便在Spring Boot应用中集成和使用OpenAPI
 *
 * @author www.seifly.cn
 */
@Configuration
public class OpenApiConfig {

    // 全局文档配置
    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact();
        contact.setName(JavaPressConfig.getAuthor());
        contact.setEmail(JavaPressConfig.getEmail());
        contact.setUrl(JavaPressConfig.getUrl());
        // 新增全局参数
        OpenAPI openAPI = new OpenAPI()
                //.components(compoents())
                //.addSecurityItem(new SecurityRequirement().addList(HttpHeaders.AUTHORIZATION))
                .info(new Info()
                        .title(JavaPressConfig.getName())
                        .contact(contact)
                        .version(JavaPressConfig.getVersion())
                        .description(JavaPressConfig.getDescription())
                        .license(new License().name(JavaPressConfig.getLicense()).url(JavaPressConfig.getLicenseUrl())));

        return openAPI;
    }

    private Components compoents() {

        return new Components().addSecuritySchemes(HttpHeaders.AUTHORIZATION, new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer"));
    }

    // 分组配置（可选）
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-apis")
                .pathsToMatch("/wp-json/**")
                .addOperationCustomizer((operation, handlerMethod) -> operation
                        .addParametersItem(buildSecurityHeaderParameter()))
                .build();
    }

    private static Parameter buildSecurityHeaderParameter() {
        return new Parameter()
                .name(HttpHeaders.AUTHORIZATION) // header 名
                .description("认证 Token") // 描述
                .in(String.valueOf(SecurityScheme.In.HEADER)) // 请求 header
                .schema(new StringSchema()._default("Bearer test1").description("认证 Token")); // 默认：使用用户编号为 1
    }

    @Bean
    public GroupedOpenApi AllApi() {
        return GroupedOpenApi.builder()
                .group("all")
                .pathsToMatch("/**")
                .addOperationCustomizer((operation, handlerMethod) -> {
                    // 1. 创建全局参数对象
                    Parameter globalParam = buildSecurityHeaderParameter();
                    // 2. 将参数添加到当前操作
                    operation.addParametersItem(globalParam);
                    return operation;
                })
                .build();
    }
}