package com.example.springtest.config;

import com.example.springtest.Interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

    // @Autowired를 사용하여 할 수도 있지만, @Autowired는 순환 참조가 발생할 수 있음음
    // 그래서 @RequiredArgsConstructor를 사용함
    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(authInterceptor);
        // 검사하고 싶은 path를 지정 또는 뺄 수 잇음
         registry.addInterceptor(authInterceptor).addPathPatterns("/private/*"); // 추가
        // registry.addInterceptor(authInterceptor).excludePathPatterns("/private/**"); // 제거
    }
}
