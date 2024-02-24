package com.example.intercepter.interceptor;

import com.example.intercepter.annotation.Auth;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String url = request.getRequestURI();
        log.info("request url : {}",url);


        boolean hasAnnotation = checkAnnotation(handler, Auth.class);

        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build().toUri();
        log.info("uri ={}",uri);

        if (hasAnnotation) {
            String query = uri.getQuery();
            if (query.equals("name=steve")){
                return true;
            }
            return false;
        }
        return true;
    }

    private boolean checkAnnotation(Object handler, Class clazz) {
         if (handler instanceof ResourceHttpRequestHandler) {
             return true;
         }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

         if (null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)) {
             return true;
         }

         return false;
    }
}
