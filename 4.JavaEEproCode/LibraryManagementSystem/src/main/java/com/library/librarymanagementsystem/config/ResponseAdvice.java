package com.library.librarymanagementsystem.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.librarymanagementsystem.model.Result;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true; // 表示生效
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 在返回之前,需要做的事情
        if(body instanceof Result){
            return body;
        }
        if(body instanceof String){
            return objectMapper.writeValueAsString(Result.success(body));
            //则不能通过下面的return来处理
        }
        return Result.success(body);
    }
}
