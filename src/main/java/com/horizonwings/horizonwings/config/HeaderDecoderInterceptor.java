package com.horizonwings.horizonwings.config;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;


public class HeaderDecoderInterceptor implements HandlerInterceptor {
    private void decodeHeader(HttpServletRequest request, String headerName) {
        String encodedValue = request.getHeader(headerName);
        if (encodedValue != null) {
            try {
                String decodedValue = URLDecoder.decode(encodedValue, StandardCharsets.UTF_8.toString());
                request.setAttribute(headerName, decodedValue);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        decodeHeader(request, "roleUserName");
        decodeHeader(request, "roleName");
        return true;
    }
}