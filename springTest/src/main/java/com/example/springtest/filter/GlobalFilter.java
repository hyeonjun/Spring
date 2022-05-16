package com.example.springtest.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
//@Component // filter 등록 -> Spring 에서 관리되도록 함
// 특정 url에만 등록하고 싶다면?
// @Component 대신 @WebFilter를 사용하고 프로퍼티에 urlPatterns가 있는데 이 곳에 url를 적고
// SpringBootApplication 클래스에 @ServletComponentScan 어노테이션 사용
// ex) @WebFilter(urlPatterns = "/api/user/*") : /api/user를 포함한 모든 하위 url 매칭
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 전처리
        ContentCachingRequestWrapper cachingRequestWrapper = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper cachingResponseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);

        String url = cachingRequestWrapper.getRequestURI();
        BufferedReader br = cachingRequestWrapper.getReader();

        br.lines().forEach(line -> {
            log.info("url: {}, line: {}", url, line);
        });
        chain.doFilter(cachingRequestWrapper, cachingResponseWrapper);

        // 후처리
        // request
        String reqContent = Arrays.toString(cachingRequestWrapper.getContentAsByteArray());
        log.info("request url: {}, requestBody: {}", url, reqContent);

        String resContent = Arrays.toString(cachingResponseWrapper.getContentAsByteArray());
        int httpStatus = cachingResponseWrapper.getStatus();

        cachingResponseWrapper.copyBodyToResponse();

        log.info("response status: {}, responseBody: {}",httpStatus, resContent);
    }

}