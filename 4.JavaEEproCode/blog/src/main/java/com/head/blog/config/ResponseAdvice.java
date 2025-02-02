package com.head.blog.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.head.blog.model.Result;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//统一返回结果
// AOP的思想
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Result){
            return body;
        }

        if (body instanceof String){
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(Result.success(body));
        }
        return Result.success(body);
    }
}
