package ru.polovinko.springmvc.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.polovinko.springmvc.interceptors.PutDealInterceptor;

@RequiredArgsConstructor
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final PutDealInterceptor putDealInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(putDealInterceptor).addPathPatterns("/api/mvc/deals/secret");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
