package cn.seifly.module.wp.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web配置类，用于定制Web MVC的配置
 * 实现了WebMvcConfigurer接口以提供额外的配置
 *
 * @author www.seifly.cn
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**/user/**", "/**/comment/add", "/**/posts/my")
                .excludePathPatterns("/**/user/login**");
    }
}
