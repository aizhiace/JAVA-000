package com.czh.geek.homework.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author Caizh
 * @date 2020/11/4
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(HttpServletRequest request, String name) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            if ("nio".equals(headerName)) {
                String headerValue = request.getHeader(headerName);
                return "请求头包含：{" + headerName + ":" + headerValue + "}；" + "响应信息：hello " + name;
            }
        }
        return "hello " + name;
    }

}
