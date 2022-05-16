package com.example.springtest.Interceptor;

import com.example.springtest.annotation.Auth;
import com.example.springtest.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component @Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws AuthException {
        String url = request.getRequestURI();
        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build().toUri();
        log.info("request url: {}", url);
        boolean hasAnnotaion = checkAnnotation(handler, Auth.class);
        log.info("has Annotation: {}", hasAnnotaion);

        // 서버는 모두 public으로 동작하면서
        // Auth 권한을 가진 요청에 대해서는 세션 or 쿠키 등의 값을 확인
        if(hasAnnotaion) {
            // 권한 체크
            String query = uri.getQuery();
            log.info("query: {}", query);
            if (query.equals("name=test")) {
                return true;
            }
            throw new AuthException();
        }

       return true;
    }

    private boolean checkAnnotation(Object handler, Class clazz) {
        // resource javascript, html,
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        // annotaion check
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // Auth annotaion이 있을 때는 true;
        return null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz);
    }
}
